package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDelimiterParser {

    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";

    private static final String CUSTOM_DELIMITER_HEAD = "//";
    private static final String CUSTOM_DELIMITER_TAIL = "\n";

    public static String[] parseText(String text) {

        if (!doesHaveDelimiter(text)) {

            return new String[]{text};
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split("[,:]");
    }

    private static boolean doesHaveDelimiter(String text) {

        if (text.contains(DELIMITER_COMMA)) {
            return true;
        }

        if (text.contains(DELIMITER_COLON)) {
            return true;
        }

        return (text.contains(CUSTOM_DELIMITER_HEAD)) && (text.contains(CUSTOM_DELIMITER_TAIL));
    }
}
