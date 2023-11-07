import java.util.Scanner;

public class Cli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> "); // Invite
        while (true) {
            String scanLine = scanner.nextLine();
            CommandLine commandLine = new CommandLine(scanLine);
            String commandName = commandLine.getCommandName(); // Stocke le nom de la commande

            String output = "";

            if (commandName.equals("exit") || commandName.equals("logout")) {
                break;
            } else if (commandName.equals("date")) {
                output = Commands.date();
            } else if (commandName.equals("time")) {
                output = Commands.time();
            } else if (commandName.equals("datetime")) {
                output = Commands.datetime();
            } else if (commandName.equals("useraccount")) {
                output = Commands.useraccount();
            } else if (commandName.equals("userhome")) {
                output = Commands.userhome();
            } else if (commandName.equals("os")) {
                output = Commands.os();
            } else if (commandName.equals("printenv")) {
                output = Commands.printenv(commandLine);
            } else if (commandName.equals("echo") || commandName.equals("print")) {
                output = Commands.echo(commandLine);
            } else if (commandName.equals("ls")) {
                output = Commands.ls(commandLine);
            } else if (commandName.equals("cat")) {
                output = Commands.cat(commandLine);
            } else {
                output = "Command '" + commandName + "' not found.";
            }
            System.out.println(output);
            System.out.print("> ");
        }
        scanner.close();
        System.out.println("Bye!");
    }
}
