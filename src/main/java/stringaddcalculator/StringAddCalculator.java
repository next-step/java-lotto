package stringaddcalculator;

public class StringAddCalculator {
    public StringAddCalculator() {
    }

    public int calculate(String input) {
        Input inputParser = new Input(input);
        Operands operands = inputParser.getOperands();
        return operands.sum().getNumber();
    }
}
