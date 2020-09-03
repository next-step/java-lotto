package cc.oakk.lotto.util;

public class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(String target) {
        return target == null || target.isEmpty();
    }

    public static int parseInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("%s는 정수로 변환할 수 없습니다.", target), e);
        }
    }
}
