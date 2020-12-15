package stringcalculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(SEPARATOR);
    }
}
