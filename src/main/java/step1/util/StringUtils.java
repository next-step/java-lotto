package step1.util;

public class StringUtils {
    public static boolean isNotBlank(String input) {
        if(input == null || input.equals("")) {
            return true;
        }
        return false;
    }
}
