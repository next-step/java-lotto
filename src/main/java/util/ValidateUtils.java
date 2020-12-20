package util;

public class ValidateUtils {
    private static final String VALID_NEGATIVE_NUMBER_MESSAGE = "음수는 입력 불가능합니다.";
    private static final int MIN_NUM = 0;

    public static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }
    
    public static void validateNegativeNumber(int num) {
        if (num < MIN_NUM) {
            throw new IllegalArgumentException(VALID_NEGATIVE_NUMBER_MESSAGE);
        }
    }
}
