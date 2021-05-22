package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMETER_VALUE = ",|:";
    public static final String CUSTOM_DELIMETER_VALUE = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if(checkNull(text))
            return 0;
        return sumInteger(seperateText(text));
    }

    private static int sumInteger(String[] seperateText) {
        int sum = 0;
        int absSum = 0;
        for (String intText : seperateText) {
            sum += Integer.parseInt(intText);
            absSum += Math.abs(Integer.parseInt(intText));
        }
        isNegative(sum, absSum);
        return sum;
    }

    private static void isNegative(int sum, int absSum) {
        if(sum != absSum || sum < 0) {
            throw new RuntimeException();
        }
    }

    private static String[] seperateText(String text) {
        String[] seperateText = customDelimiter(text);
        if(seperateText != null)
            return seperateText;
        return defaultDelimeter(text);
    }

    private static String[] customDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMETER_VALUE).matcher(text);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return null;
    }

    private static String[] defaultDelimeter(String text) {
        return text.split(DEFAULT_DELIMETER_VALUE);
    }

    private static boolean checkNull(String text) {
        if(text == null || text.isEmpty())
            return true;
        return false;
    }
}