package stringCalculator.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import stringCalculator.common.Constant;

public class PatternChecker {
    private static final int DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;
    private final Matcher matcher;

    public PatternChecker(String input) {
        matcher = Pattern.compile(Constant.CUSTOM_PATTERN).matcher(input);
    }

    public boolean isCustomDelimiter() {
        return matcher.find();
    }

    public String getDelimiter() {
        return matcher.group(DELIMITER_INDEX);
    }

    public String getText() {
        return matcher.group(TEXT_INDEX);
    }
}