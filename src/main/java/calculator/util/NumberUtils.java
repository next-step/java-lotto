package calculator.util;

import java.util.regex.Pattern;

public class NumberUtils {

    private static final Pattern negativeNumberPattern = Pattern.compile("-\\d+");

    private NumberUtils() {}

    public static boolean isNegativeInt(String str){
        return negativeNumberPattern.matcher(str).matches();
    }
}
