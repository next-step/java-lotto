package lotto.step2.utils;

public class StringUtils {
    public static boolean isBlank(String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        return false;
    }
}
