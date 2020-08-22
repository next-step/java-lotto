package step1.util;


public class StringUtil {
    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }

        return "".equals(value);
    }
}
