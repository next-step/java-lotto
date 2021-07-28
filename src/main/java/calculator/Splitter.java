package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final String DELIMITER = "[,:]";
    private static final int INDEX_OF_CUSTOM_DELIMITER = 1;
    private static final int INDEX_OF_NUMBERS = 2;

    private Splitter() {
    }

    public static String[] split(String inputText) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(inputText);
        if (matcher.find()) {
            String customDelimiter = matcher.group(INDEX_OF_CUSTOM_DELIMITER);
            return matcher.group(INDEX_OF_NUMBERS).split(customDelimiter);
        }
        return inputText.split(DELIMITER);
    }
}
