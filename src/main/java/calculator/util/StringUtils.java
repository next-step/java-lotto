package calculator.util;

/**
 * Created by seungwoo.song on 2022-09-28
 */
public class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String input) {
        for (char c : input.toCharArray()) {
            if (c != ' ') {
                return false;
            }
        }
        return true;
    }
}
