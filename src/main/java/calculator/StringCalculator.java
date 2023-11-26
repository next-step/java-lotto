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

    public static int plus(String text) {
        isBlank(text);
        String[] split = getSplit(text);
        int result = Integer.parseInt(split[0]) + Integer.parseInt(split[2]);
        return result;
    }

    public static int minus(String text) {
        isBlank(text);
        String[] split = getSplit(text);
        int result = Integer.parseInt(split[0]) - Integer.parseInt(split[2]);
        return result;
    }

    public static int multiply(String text) {
        isBlank(text);
        String[] split = getSplit(text);
        int result = Integer.parseInt(split[0]) * Integer.parseInt(split[2]);
        return result;
    }

    public static int divide(String text) {
        isBlank(text);
        String[] split = getSplit(text);
        int result = Integer.parseInt(split[0]) / Integer.parseInt(split[2]);
        return result;
    }

}
