package StringAddCalculator;

public class StringAddCalculator {
    public StringAddCalculator() {
    }

    public int calculate(String input) {
        InputParser inputParser = new InputParser(input);
        Operands operands = inputParser.getOperands();
        return operands.sum().getNumber();
    }
}
