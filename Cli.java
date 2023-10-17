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
            String[] commandArgs = command.split(" ", 2);
            String output = ""; // Variable pour stocker la sortie
            if (command.equals("exit") || command.equals("logout")) {
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
            } else if (command.equals("useraccount")) {
                String username = System.getProperty("user.name");
                output = username;
            } else if (command.equals("userhome")) {
                String userhome = System.getProperty("user.home");
                output = userhome;
            } else if (command.equals("os")) {
                String os = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
                output = os;
            }  else if (commandArgs.length > 1) {
                String arg = System.getenv(commandArgs[1]);
                if (arg == null) {
                    output = "";
                } else {
                    output = arg;
                }
               

            }
                else if (commandArgs[0].equals("printenv")) {
                // return all environment variables and replace ", " by "\n"
                String envProperties = System.getenv().toString().replace(", ", "\n");
                System.out.println(envProperties);
            

           
            } else if (command.startsWith("echo") || command.startsWith("print")) {
                if (command.length() > "echo ".length()) {
                    String[] arguments = command.substring("echo ".length()).split(" ");
                    output = String.join(" ", arguments);
                } else {
                    output = "";
                }
            } else {
                output = "Command '" + command + "' not found.";
            }
            System.out.println(output);
            System.out.print("> "); // Invite
        }
        scanner.close();
        System.out.println("Bye !");
    }
}