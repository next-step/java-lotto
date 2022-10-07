package calculator;

public class Calculator {

    public static final String INTEGER_REGEX = "[+-]?\\d*";
    public static final String BLANK_REGEX = "\\s+";

    public static int calculate(String text) {
        String[] values = getSplitInput(text);
        int result = getOperand(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int operand = getOperand(values[i + 1]);
            result = OperatorType.calculate(result, operator, operand);
        }
        return result;
    }

    private static String[] getSplitInput(String text) {
        if (text == null) {
            throw new IllegalArgumentException("연산에 필요한 피연산자가 입력되지 않았습니다.");
        }
        return text.split(BLANK_REGEX);
    }

    private static int getOperand(String value) {
        if (!value.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException("피연산자는 정수만 가능합니다.");
        }
        return Integer.parseInt(value);
    }
}
