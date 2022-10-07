package calculator;

public class Calculator {

    public static final String INTEGER_REGEX = "[+-]?\\d*";

    public static int calculate(String text) {
        String[] values = getSplitInput(text);
        int result = getOperand(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            int operand = getOperand(values[i + 1]);
            result = OperatorType.calculate(result, operand, values[i]);
        }
        return result;
    }

    private static String[] getSplitInput(String text) {
        if (text == null) {
            throw new IllegalArgumentException("연산에 필요한 피연산자가 입력되지 않았습니다.");
        }
        return text.split(" ");
    }

    private static int getOperand(String value) {
        value = value.trim();
        if (value.length() == 0) {
            throw new IllegalArgumentException("연산에 필요한 피연산자가 입력되지 않았습니다.");
        }
        if (!value.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException("피연산자는 정수만 가능합니다.");
        }
        return Integer.parseInt(value);
    }
}
