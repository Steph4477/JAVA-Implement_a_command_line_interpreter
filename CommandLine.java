public class CommandLine {
    private String commandName;
    private String argument;

    public CommandLine(String input) {
        String[] commandTable = input.split(" ", 2);
        this.commandName = commandTable[0];
        this.argument = (commandTable.length > 1) ? commandTable[1] : null;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getArgument() {
        return argument;
    }

    public boolean hasArgument() {
        return argument != null;
    }
}
