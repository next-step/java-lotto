public class Calculator {
    private final Command command;

    public Calculator(Command command) {
        this.command = command;
    }

    public int calculate(int a, int b) {
        return command.calculate(a, b);
    }
}
