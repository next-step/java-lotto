package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDelimiterParser {

    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";

    private static final String CUSTOM_DELIMITER_HEAD = "//";
    private static final String CUSTOM_DELIMITER_TAIL = "\n";

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] parseText(String text) {

        if (!doesHaveDelimiter(text)) {
            return new String[]{text};
        }

        Matcher matcher = PATTERN.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split("[,:]");
    }

    private static boolean doesHaveDelimiter(String text) {

        if (text.contains(DELIMITER_COMMA) || (text.contains(DELIMITER_COLON))) {
            return true;
        }

        return (text.contains(CUSTOM_DELIMITER_HEAD)) && (text.contains(CUSTOM_DELIMITER_TAIL));
    }
}
