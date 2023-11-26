package calculator;

public class StringCalculator {

    public static String[] getSplit(String text) {
        String[] split = text.split(" ");
        return split;
    }

    public static boolean isBlank(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 빈문자열 또는 공백입니다.");
        }
        return true;
    }

    public static int plus(int number1, int number2) {
        return number1 + number2;
    }

    public static int minus(int number1, int number2) {
        return number1 - number2;
    }

    public static int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public static int divide(int number1, int number2) {
        return number1 / number2;
    }

    public static int calculate(String input) {
        isBlank(input);
        String[] split = getSplit(input);
        int result = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i += 2) {
            int nextNumber = Integer.parseInt(split[i + 1]);
            result = operate(result, nextNumber, split[i]);
        }
        return result;
    }

    private static int operate(int number1, int number2, String operator) {
        switch (operator) {
            case "+":
                return plus(number1, number2);
            case "-":
                return minus(number1, number2);
            case "*":
                return multiply(number1, number2);
            case "/":
                return divide(number1, number2);
            default:
                throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + operator);
        }
    }
}
