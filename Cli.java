import java.util.Scanner;

public class Cli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> "); // Invite
        while (true) {
            String scanLine = scanner.nextLine();
            CommandLine commandLine = new CommandLine(scanLine);
            String output = "";
          
            if (commandLine.getCommandName().equals("exit") || commandLine.getCommandName().equals("logout")) {
                break;
            } else if (commandLine.getCommandName().equals("date")) {
                output = Commands.date();
            }  else if (commandLine.getCommandName().equals("time")) {
                output = Commands.time();
            } else if (commandLine.getCommandName().equals("datetime")) {
                output = Commands.datetime();
            } else if (commandLine.getCommandName().equals("useraccount")) {
                output = Commands.useraccount();
            } else if (commandLine.getCommandName().equals("userhome")) {
                output = Commands.userhome();
            } else if (commandLine.getCommandName().equals("os")) {
                output = Commands.os(); 
            } else if (commandLine.getCommandName().equals("printenv")) {
                output = Commands.printenv(commandLine);
            } else if (commandLine.getCommandName().equals("echo") || commandLine.getCommandName().equals("print")) {
                output = Commands.echo(commandLine); 
            } else if (commandLine.getCommandName().equals("ls")) {
                output = Commands.ls(commandLine);            
            } else {
                output = "Command '" + commandLine.getCommandName() + "' not found.";
            }        
            System.out.println(output);
            System.out.print("> "); 
        }
        scanner.close();
        System.out.println("Bye!");
    }
}

