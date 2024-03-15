package caculator;

public class Calculator {

    public static int calculateTwoNumber(final int number1, final String operation, final int number2) {
        if ("+".equals(operation)) {
            return number1 + number2;
        }
        if ("-".equals(operation)) {
            return number1 - number2;
        }
        if ("*".equals(operation)) {
            return number1 * number2;
        }
        if ("/".equals(operation)) {
            validateNonZero(number2);
            return number1 / number2;
        }
        throw new IllegalArgumentException("연산 기호가 올바르지 않습니다.");
    }

    private static void validateNonZero(final int number) {
        if (number == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
