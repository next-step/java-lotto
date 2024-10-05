package calculator;

public class StringCalculator {
    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String MULTIPLE = "*";
    private final static String DIVISION = "/";

    private static final String INCORRECT_VALUE_ERROR_MESSAGE = "입력값이 비었거나 null 입니다.";
    private static final String INCORRECT_DIVISION_ERROR_MESSAGE = "0으로 나눌수 없습니다.";

    public StringCalculator() {
    }

    public static int run(final String inputValue) {
        validateIsBlank(inputValue);
        String[] arr = Splitter.split(inputValue);

        int result = Integer.parseInt(arr[0]);

        for (int i = 1; i < arr.length; i += 2) {
            result = calculate(arr[i], result, Integer.parseInt(arr[i+1]));
        }

        return result;
    }

    private static int calculate(final String operator, int number, int number2) {
        if (operator.equals(PLUS)) {
            return sum(number, number2);
        }
        if (operator.equals(MINUS)) {
            return minus(number, number2);
        }
        if (operator.equals(MULTIPLE)) {
            return multiple(number, number2);
        }
        if (operator.equals(DIVISION)) {
            return divide(number, number2);
        }
        return 0;
    }

    private static int sum(final int num1, final int num2) {
        return num1 + num2;
    }

    private static int minus(final int num1, final int num2) {
        return num1 - num2;
    }

    private static int multiple(final int num1, final int num2) {
        return num1 * num2;
    }

    private static int divide(final int num1, final int num2) {
       if (num2 == 0) {
           throw new IllegalArgumentException(INCORRECT_DIVISION_ERROR_MESSAGE);
       }
       return num1 / num2;
    }

    private static void validateIsBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(INCORRECT_VALUE_ERROR_MESSAGE);
        }
    }
}
