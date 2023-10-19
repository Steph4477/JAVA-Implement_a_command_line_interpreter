import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Cli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> "); // Invite
        while (true) {
            String scanLine = scanner.nextLine();
            String[] commandTable = scanLine.split(" ", 2); // Split la ligne de commande
            String commandName = commandTable[0];
            String arguments = (commandTable.length > 1) ? commandTable[1] : "";
            String output = "";

            if (commandName.equals("exit") || commandName.equals("logout")) {
                System.out.println("Bye !");
                scanner.close();
                break;

            } else if (commandName.equals("date")) {
                output = LocalDate.now().toString();
            } else if (commandName.equals("time")) {
                output = LocalTime.now().toString();
            } else if (commandName.equals("datetime")) {
                output = LocalDateTime.now().toString();
            } else if (commandName.equals("useraccount")) {
                output = System.getProperty("user.name");
            } else if (commandName.equals("userhome")) {
                output = System.getProperty("user.home");
            } else if (commandName.equals("os")) {
                StringBuilder buildOs = new StringBuilder();
                buildOs
                        .append(System.getProperty("os.name"))
                        .append(" (")
                        .append(System.getProperty("os.version"))
                        .append(")");
                output = buildOs.toString();
            } else if (commandName.equals("printenv")) {
                if (!arguments.isEmpty()) {
                    String value = System.getenv(arguments);
                    output = (value != null) ? value : "command not found";
                } else {
                    StringBuilder buildPrintenv = new StringBuilder();
                    Map<String, String> env = System.getenv();
                    for (Map.Entry<String, String> entry : env.entrySet()) {
                        buildPrintenv
                                .append(entry.getKey())
                                .append("=")
                                .append(entry.getValue())
                                .append(System.lineSeparator());
                    }
                    output = buildPrintenv.toString();
                }
            } else if (commandName.equals("echo") || commandName.equals("print")) {
                output = arguments;
            } else if (commandName.equals("ls")) {
                File folder = new File(arguments);
                if (folder.isDirectory()) {
                    StringBuilder buildLs = new StringBuilder();
                    File[] files = folder.listFiles();
                    for (File file : files) {
                        buildLs
                                .append(file.getName())
                                .append(System.lineSeparator());
                    }
                    output = buildLs.toString();
                } else {
                    output = "Not a directory";
                }

            } else {
                StringBuilder cnf = new StringBuilder();
                cnf
                        .append("Command '")
                        .append(commandName)
                        .append("' not found.");
                output = cnf.toString();
            }
            System.out.println(output);
            System.out.print("> "); // Invite
        }
    }
}