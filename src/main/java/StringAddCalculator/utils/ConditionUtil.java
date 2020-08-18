package StringAddCalculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConditionUtil {

    public static boolean getCheckNullOrEmpty(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String[] getPatternCustom(String[] numberArr, String numbers) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        if (m.find()) {
            String customDelimiter = m.group(1);
            numberArr = m.group(2).split(customDelimiter);
        }
        return numberArr;
    }
}
