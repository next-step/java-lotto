package calculator.util;

import java.util.regex.Pattern;

public class NumberUtils {

    private static final Pattern pattern = Pattern.compile("-\\d+");

    private NumberUtils() {}

    public static boolean isNegativeInt(String str){
        return pattern.matcher(str).matches();
    }
}
