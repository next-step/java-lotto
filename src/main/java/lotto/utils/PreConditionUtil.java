package lotto.utils;

public class PreConditionUtil {

    private static final String CHECK_NULL_OR_EMPTY = "null 또는 빈 값인지 확인해주세요";

    private PreConditionUtil() {
    }

    public static void checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(CHECK_NULL_OR_EMPTY);
        }
    }
}
