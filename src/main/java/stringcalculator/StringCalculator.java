package stringcalculator;

public class StringCalculator {
    private static final String NOT_ALLOW_NULL_OR_EMPTY_MESSAGE = "비거나 null값은 허용되지 않습니다.";

    public int plus(String expression) {
        checkEmpty(expression);

        int result = 0;
        String[] strings = expression.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if ("+".equals(strings[i])) {
                result += Integer.parseInt(strings[i - 1]);
            }
        }
        result += Integer.parseInt(strings[strings.length - 1]);

        return result;
    }

    private void checkEmpty(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(NOT_ALLOW_NULL_OR_EMPTY_MESSAGE);
        }
    }
}
