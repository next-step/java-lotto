package lotto.util;

public class Util {

    private static final String ILLEGAL_LOTTO_NUMBER = "로또 번호는 1이상 45이하의 숫자입니다.";

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static int convertInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER);
        }
    }
}
