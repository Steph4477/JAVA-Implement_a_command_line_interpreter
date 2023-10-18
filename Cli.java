
/*
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Cli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> "); // Invite
        while (true) {
            String command = scanner.nextLine();
            String[] commandTable = command.split(" ", 2); // split le tableau en 2 après l'espace
            String output = ""; // Variable pour stocker la sortie
            String lineSeparator = System.getProperty("line.separator");
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
            } else if (command.equals("printenv")) {
                if (commandTable.length > 1) {
                    String arg = commandTable[1];
                    String value = System.getenv(arg);
                    output = (value != null) ? value : "";
                } else {
                    Map<String, String> env = System.getenv();
                    for (Map.Entry<String, String> entry : env.entrySet()) {
                        output += entry.getKey() + "=" + entry.getValue() + lineSeparator;
                    }
                }
            } else if ((commandTable[0].equals("echo")) || (commandTable[0].equals("print"))) {
                output = commandTable[1];
           
            } else if (command.length() > "printenv ".length()) {
                String varInput = command.substring("printenv ".length());
                String value = System.getenv(varInput);
                output = (value != null) ? value : "";
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
*/
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Cli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> "); // Invite
        while (true) {
            String commandLine = scanner.nextLine();
            String[] commandTable = commandLine.split(" ", 2); // Split la ligne de commande
            String command = commandTable[0]; 
            String arguments = (commandTable.length > 1) ? commandTable[1] : "";
            String output = ""; // Variable pour stocker la sortie
            String lineSeparator = System.getProperty("line.separator");

            if (command.equals("exit") || command.equals("logout")) {
                System.out.println("Bye !");
                scanner.close();
                return;
            } else if (command.equals("date")) {
                output = LocalDate.now().toString();
            } else if (command.equals("time")) {
                output = LocalTime.now().toString();
            } else if (command.equals("datetime")) {
                output = LocalDateTime.now().toString();
            } else if (command.equals("useraccount")) {
                output = System.getProperty("user.name");
            } else if (command.equals("userhome")) {
                output = System.getProperty("user.home");
            } else if (command.equals("os")) {
                output = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")";
            } else if (command.equals("printenv")) {
                if (!arguments.isEmpty()) {
                    String value = System.getenv(arguments);
                    output = (value != null) ? value : "";
                } else {
                    Map<String, String> env = System.getenv();
                    for (Map.Entry<String, String> entry : env.entrySet()) {
                        output += entry.getKey() + "=" + entry.getValue() + lineSeparator;
                    }
                }
            } else if (command.equals("echo") || command.equals("print")) {
                output = arguments;
            } else {
                output = "Command '" + command + "' not found.";
            }

            System.out.println(output);
            System.out.print("> "); // Invite
        }
    }
}
