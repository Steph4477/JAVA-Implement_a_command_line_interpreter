class CommandLine {
    private String commandName;
    private String argument;

    public CommandLine(String commandLine) {
        String[] commandTable = commandLine.split(" ", 2);
        this.commandName = commandTable[0];
        this.argument = (commandTable.length > 1) ? commandTable[1] : null;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public String getArgument() {
        return this.argument;
    }

    public boolean hasArgument() {
        return this.argument != null;
    }
}
