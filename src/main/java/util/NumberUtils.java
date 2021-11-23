package util;

import java.util.regex.Pattern;

public class NumberUtils {

    private static final Pattern negativeNumberPattern = Pattern.compile("-\\d+");
    private static final Pattern numberPattern = Pattern.compile("-?\\d+");

    private NumberUtils() {}

    public static boolean isNegativeInt(String str){
        return negativeNumberPattern.matcher(str).matches();
    }

    public static boolean isIntValue(String str){
        return numberPattern.matcher(str).matches();
    }
}
