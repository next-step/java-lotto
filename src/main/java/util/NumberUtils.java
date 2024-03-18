package util;

import java.util.regex.Pattern;

public class NumberUtils {

    private static final Pattern pattern = Pattern.compile("\\d");

    public static boolean isNumber(String str) {
        return pattern.matcher(str).find();
    }
}
