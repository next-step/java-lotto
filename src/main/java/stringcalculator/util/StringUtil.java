package stringcalculator.util;

public class StringUtil {

    private StringUtil() {
    }

    public static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

}
