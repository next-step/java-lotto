package calculator;

public class StringAdditionCalculator {

    public static int add(int[] operands) {
        int result = 0;
        for (int operand : operands) {
            result += operand;
        }
        return result;
    }
}
