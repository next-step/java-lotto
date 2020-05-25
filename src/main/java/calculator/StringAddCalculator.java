package calculator;


public class StringAddCalculator {

    public static int sum(String text) {
        PositiveNumber[] operands = OperandExtractor.getOperand(text);
        int sum = 0;
        for(PositiveNumber operand : operands) {
            sum += operand.getNumber();
        }
        return sum;
    }
}
