package calculator.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNumeric(String value) {
        return value.chars().allMatch(Character::isDigit);
    }

    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
