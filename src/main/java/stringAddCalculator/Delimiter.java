package stringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String BASIC_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static String[] isBasicOrCustom(String input) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(input);
        if(matcher.find()) {
            return customDelimiter(matcher);
        }
        return basicDelimiter(input);
    }

    private static String[] basicDelimiter(String input){
        return input.split(BASIC_DELIMITER);
    }

    private static String[] customDelimiter(Matcher input) {
        String customDelimiter = input.group(1);
        return input.group(2).split(customDelimiter);
    }
}
