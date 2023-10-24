import java.util.Scanner;

public class Cli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> "); // Invite
        while (true) {
            String scanLine = scanner.nextLine();
            CommandLine commandLine = new CommandLine(scanLine);
            String commandName = commandLine.getCommandName();
            String output = Commands.executeCommand(commandLine);

            if ((commandName.equals("exit")) || (commandName.equals("logout"))) {
                System.out.println("Bye !");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println(output);
                System.out.print("> "); // Invite
            }
        }
    }
}
