package calculator.utils;

import com.sun.xml.internal.rngom.parse.Parseable;
import spark.utils.StringUtils;

public class ValidationCheck {

    public static boolean isNegative(String[] strings) {
        for (String s : strings) {
            if (negativeCheck(s)) return true;
        }
        return false;
    }

    private static boolean negativeCheck(String s) {
        if (Integer.parseInt(s) < 0) {
            return true;
        }
        return false;
    }

    public static boolean isBlank(String s) {
        return StringUtils.isBlank(s);
    }
}
