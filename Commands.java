import java.util.Map;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Commands {
    public static String executeCommand(CommandLine commandLine) {
        String commandName = commandLine.getCommandName();
        String argument = commandLine.getArgument();
        String output = "";
        if (commandName.equals("date")) {
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
            if (commandLine.hasArgument()) {
                String value = System.getenv(argument);
                output = (value != null) ? value : "";
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
            output = argument;
        } else if (commandName.equals("ls")) {
            if (argument == null) {
                output = "Usage: ls [directory]";
            } else {
                File folder = new File(argument);
                if (folder.isDirectory()) {
                    StringBuilder buildLs = new StringBuilder();
                    File[] files = folder.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            buildLs
                                    .append(file.getName())
                                    .append(System.lineSeparator());
                        }
                        output = buildLs.toString();
                    } else {
                        output = "Directory is empty";
                    }
                } else {
                    output = "Not a directory";
                }
            }   
        } else {
            StringBuilder cnf = new StringBuilder();
            cnf
                    .append("Command '")
                    .append(commandName)
                    .append("' not found.");
            output = cnf.toString();
        }
        return output;
    }
}

