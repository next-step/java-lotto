package stringCalculator.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import stringCalculator.common.Constant;

public class PatternChecker {
    String delimiter;
    String text;

    public void setTextAndDelimiter(String input) {
        initTextAndDelimiter(input);
        Matcher matcher = Pattern.compile(Constant.CUSTOM_PATTERN).matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(Constant.DELIMITER_GROUP);
            text = matcher.group(Constant.TEXT_GROUP);
        }
    }

    private void initTextAndDelimiter(String input) {
        text = input;
        delimiter = Constant.DEFAULT_DELIMITER;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getText() {
        return text;
    }
}