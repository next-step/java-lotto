package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SplitUtil {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\n(.*)");

    private SplitUtil() {
    }

    public static String[] splitByDelimiter(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        String delimiter = DEFAULT_DELIMITER;
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }
        return text.split(delimiter);
    }

}
