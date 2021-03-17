package study;

public class ExpressionValidator {
    public static String convertBlankOrNullToZero(String value) {
        if (value == null || "".equals(value)) {
            return "0";
        }
        return value;
    }

    public static int convertIfValidNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("입력 값에는 숫자만 들어갈 수 있습니다.");
        }
    }

    public static boolean isPositiveNumber(int value) {
        if (value < 0) {
            throw new RuntimeException("음수 값은 들어갈 수 없습니다.");
        }
        return true;
    }

}
