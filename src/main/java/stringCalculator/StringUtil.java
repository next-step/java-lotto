package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String[] complicatedSeparator(String inputString) {
        String separator = ",|;";
        Matcher matcher = getCustomMatcher(inputString);
        if(matcher.find()){
            separator = separator + "|" + matcher.group(1);
            return matcher.group(2).split(separator);
        }
        return inputString.split(separator);
    }

    private static Matcher getCustomMatcher(String inputString){
        return Pattern.compile("//(.)\n(.*)").matcher(inputString);
    }
}
