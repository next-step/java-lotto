package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class StringSplitter {
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final Pattern CUSTOM_SEPARATOR = compile("//(.)\n(.*)");

    public static Elements splitToElements(String inputString) {
        return Elements.from(splitToArray(inputString));
    }

    public static String[] splitToArray(String inputString) {
        String[] elements = inputString.split(DEFAULT_SEPARATOR);
        Matcher m = CUSTOM_SEPARATOR.matcher(inputString);
        if(m.find()) {
            String customSeparator = m.group(1);
            elements = m.group(2).split(customSeparator);
        }
        return elements;
    }
}
