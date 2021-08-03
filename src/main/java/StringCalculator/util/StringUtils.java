package StringCalculator.util;

public class StringUtils {

    public static boolean checkNullOrEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

}
