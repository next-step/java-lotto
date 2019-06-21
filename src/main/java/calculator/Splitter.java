package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String REGEX_OF_DEFAULT_SEPARATOR = "[,:]";
    private static final String REGEX_OF_CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public String[] split(String input) {
        String[] elementsOnInput = input.split(REGEX_OF_DEFAULT_SEPARATOR);

        Matcher matcher = Pattern.compile(REGEX_OF_CUSTOM_SEPARATOR).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            elementsOnInput = matcher.group(2).split(customDelimiter);
        }
        return elementsOnInput;
    }
}
