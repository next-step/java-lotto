package calculator.util;

/**
 * Created by seungwoo.song on 2022-09-28
 */
public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNotBlank(String text) {
        return !isBlank(text);
    }

    public static boolean isBlank(String text) {
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                return false;
            }
        }
        return true;
    }
}
