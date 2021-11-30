package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final int DELIMITER_INDEX = 1;
    public static final int NUMBER_INDEX = 2;

    private String delimiter = DEFAULT_DELIMITER;

    public List<String> split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

        if (m.find()) {
            delimiter = m.group(DELIMITER_INDEX);
            return Arrays.asList(m.group(NUMBER_INDEX).split(delimiter));
        }
        return Arrays.asList(text.split(delimiter));
    }

    public boolean isEmpty(String text) {
        return text != null && !text.isEmpty();
    }
}
