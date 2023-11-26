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

}
