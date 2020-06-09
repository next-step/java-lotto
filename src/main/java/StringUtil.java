public class StringUtil {

    static int parseInt(String text) {
        return Integer.parseInt(text);
    }

    static boolean isNumeric(String text) {
        return text.chars().allMatch(Character::isDigit);
    }

    static boolean isNull(String text) {
        return text == null;
    }

    static boolean isEmpty(String text) {
        return text.isEmpty();
    }
}
