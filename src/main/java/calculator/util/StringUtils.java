package calculator.util;

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("유틸 클래스는 생성할 수 없습니다.");
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
