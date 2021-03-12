package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {

    public String[] splitStrings(String text) {
        Matcher m = Pattern.compile(Constants.REGEX_CUSTOM_DELIMITER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(Constants.POSITION_OF_CUSTOM_DELIMITER);
            return m.group(Constants.POSITION_OF_TEXT).split(customDelimiter);
        }

        return text.split(Constants.REGEX_BASIC_DELIMITER);
    }
}
