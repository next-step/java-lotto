package StringAddCalculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCustomDelimiter {

    //matcherTest
    public static String returnCustomDelimiter(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            //String[] tokens = m.group(2).split(customDelimiter);
            return customDelimiter;
        }
        return null;
    }

    public static boolean isNotCustomDelimiter(String delimiter, String customDelimiter) {
        return delimiter != customDelimiter;
    }

    public static boolean isInvalidCustomDelimiter(String delimiter, String customDelimiter) {
        return CheckCustomDelimiter.isNotCustomDelimiter(delimiter, customDelimiter) || CheckString.isNullOrBlank(delimiter);
    }


}
