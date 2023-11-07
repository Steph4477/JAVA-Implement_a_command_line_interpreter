import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

class Commands {
    public static String date() {
        return LocalDate.now().toString();
    }

    public static String time() {
        return LocalTime.now().toString();
    }

    public static String datetime() {
        return LocalDateTime.now().toString();
    }

    public static String useraccount() {
        return System.getProperty("user.name");
    }

    public static String userhome() {
        return System.getProperty("user.home");
    }

    public static String os() {
        StringBuilder buildOs = new StringBuilder();
        buildOs
                .append(System.getProperty("os.name"))
                .append(" (")
                .append(System.getProperty("os.version"))
                .append(")");
        return buildOs.toString();
    }

    public static String printenv(CommandLine commandLine) {
        if (commandLine.hasArgument()) {
            String value = System.getenv(commandLine.getArgument());
            return value != null ? value : "";
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
            return buildPrintenv.toString();
        }
    }

    public static String echo(CommandLine commandLine) {
        return commandLine.hasArgument() ? commandLine.getArgument() : "";
    }

    public static String ls(CommandLine commandLine) {
        if (commandLine.hasArgument()) {
            File folder = new File(commandLine.getArgument());
            if (folder.isDirectory()) {
                StringBuilder buildLs = new StringBuilder();
                File[] files = folder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        buildLs
                                .append(file.getName())
                                .append(System.lineSeparator());
                    }
                    return buildLs.toString();
                } else {
                    return "Directory is empty";
                }
            }
        }
        // Retour par défaut si l'argument est nul ou vide
        return "Not a directory";
    }

    public static String cat(CommandLine commandLine) {
        if (commandLine.hasArgument()) {
            String filePath = commandLine.getArgument();
            StringBuilder buildCat = new StringBuilder();
            int lineNumber = 1;
            try {
                for (String line : Files.readAllLines(Paths.get(filePath))) {
                    buildCat.append(lineNumber++)
                            .append(". ")
                            .append(line)
                            .append(System.lineSeparator());
                }
            } catch (Exception e) {
                return "Error reading file";
            }
            return buildCat.toString();
        } else {
            return "Please specify a path to a text file to read";
        }
    }

    public static String greet(CommandLine commandLine) {
        if (commandLine.hasArgument()) {
            String username = commandLine.getArgument();
            return "Hello, " + username + "! Welcome to our CLI.";
        } else {
            return "Please give me your username after the 'greet' command :).";
        }
    }

    public static String help() {
        String filePath = "help.txt"; // Chemin vers le fichier de commandes
        StringBuilder result = new StringBuilder("List commands:").append(System.lineSeparator());
        int lineNumber = 1;
        try {
            for (String line : Files.readAllLines(Paths.get(filePath))) {
                result.append(lineNumber++)
                        .append(". ")
                        .append(line)
                        .append(System.lineSeparator());
            }
            return result.toString();
        } catch (Exception e) {
            return "Error reading the command list file.";
        }
    }
}
