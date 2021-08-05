package stringaddcalculator.util;

public class StringUtil {

    public static boolean isBlank(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }

}
