package stringcalculator;

public class StringUtils {
    public static boolean hasText(String str) {
        if (str == null) {
            return false;
        }
        if (str.isBlank()) {
            return false;
        }
        return true;
    }
}
