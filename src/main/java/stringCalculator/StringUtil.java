package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String[] separator(String inputString) {
        return inputString.split(",|;");
    }


    public static String[] customSeparator(String customSeparatorContainString) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(customSeparatorContainString);
        if(matcher.find()){
            String customSeparator = matcher.group(1);
            String[] test = matcher.group(2).split(customSeparator);
            return test;
        }
        return separator(customSeparatorContainString);
    }
}
