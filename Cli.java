
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Cli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> "); // Invite
        while (true) {
            String command = scanner.nextLine(); // Obtenir l'entrée de la console sous forme de chaîne
            String output = ""; // Variable pour stocker la sortie
            if (command.equals("exit")) {
                break; // Quitter la boucle si la commande est "exit"
            } else if (command.equals("date")) {
                LocalDate today = LocalDate.now();
                output = today.toString();
            } else if (command.equals("time")) {
                LocalTime now = LocalTime.now();
                output = now.toString();
            } else if (command.equals("datetime")) {
                LocalDateTime now = LocalDateTime.now();
                output = now.toString();
            } else if (command.equals("userhome")) {
                String userhome = System.getProperty("user.home");
                output = userhome;
            } else if (command.equals("os")) {
                String os = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
                output = os;
            }
            else if (command.equals("printenv")) {
                String varInput = scanner.nextLine();
                String value = System.getenv(varInput);
                output = (value != null) ? value : "";  // Si la variable n'existe pas, imprime une chaîne vide
            } else if (command.equals("echo")) {
                System.out.print("Veuillez entrer votre texte : ");
                String repeat = scanner.nextLine();
                output = repeat;
            } else {
                output = "Commande '" + command + "' non trouvée.";
            }
            System.out.println(output);
            System.out.print("> "); // Invite
        }

        scanner.close();
        System.out.println("Bye !");
    }
}

            
 