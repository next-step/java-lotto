package calculator.utils;

public class StringUtils {

    private static final String NULL_MESSAGE = "입력한 문자열은 null 값을 허용하지 않습니다";
    private static final String BLANK_MESSAGE = "입력한 문자열은 빈 공백 문자를 허용하지 않습니다";
    private static final String INSTANCE_ERROR_MESSAGE = "StringUtils 클래스를 인스턴스화 할수 없습니다";

    private StringUtils() {
        throw new AssertionError(INSTANCE_ERROR_MESSAGE);
    }

    public static void isNullOrBlank(String str) {
        nullCheck(str);

        blankCheck(str);
    }

    private static void nullCheck(String str) {
        if (str == null) {
            throw new NullPointerException(NULL_MESSAGE);
        }
    }

    private static void blankCheck(String str) {
        if(str.isBlank()) {
            throw new IllegalArgumentException(BLANK_MESSAGE);
        }
    }
}
