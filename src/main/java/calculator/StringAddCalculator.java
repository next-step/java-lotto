package calculator;


public class StringAddCalculator {

    public static int sum(String text) {
        String[] operands = OperandExtractor.getOperand(text);
        int[] intOperands = OperandExtractor.valueOf(operands);
        int sum = 0;
        for(int operand : intOperands) {
            sum += operand;
        }
        return sum;
    }
}
