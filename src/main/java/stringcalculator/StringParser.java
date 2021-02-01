package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final String NORMAL_SEPARATOR = "[,:]";

    private StringParser() {
    }

    public static String[] split(String inputText) {
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(inputText);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return inputText.split(NORMAL_SEPARATOR);
    }
}