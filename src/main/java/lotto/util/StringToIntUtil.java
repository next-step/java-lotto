package lotto.util;

public class StringToIntUtil {

    public static int apply(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 문자열입니다.");
        }
    }
}
