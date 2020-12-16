package stringcalculator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String SEPARATOR = "[,:]";
    private static final Pattern CUSTOM_SEPARATOR = Pattern.compile("//(.)\n(.*)");

    public List<String> split(String text) {
        Matcher match = CUSTOM_SEPARATOR.matcher(text);
        if(match.find()) {
            String customDelimiter = match.group(1);
            String matchText = match.group(2);
            return Arrays.asList(matchText.split(customDelimiter));
        }

        return Arrays.asList(text.split(SEPARATOR));
    }
}
