package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterRegex {

    private static final String REGEX_CUSTOM_DELIMITER = "^\\/\\/(.+)\\\\n";
    private static final String REGEX_INPUT = "\\\\n(.+)";

    private static final Pattern PATTERN_CUSTOM_DELIMITER = Pattern.compile(REGEX_CUSTOM_DELIMITER);
    private static final Pattern PATTERN_INPUT = Pattern.compile(REGEX_INPUT);
    private static final Integer DELIMITER_GROUP = 1;

    private DelimiterRegex() {
    }

    public static String getCustomDelimiter(String formula) {
        Matcher matcher = PATTERN_CUSTOM_DELIMITER.matcher(formula);

        if (matcher.find()) {
            return matcher.group(DELIMITER_GROUP);
        }

        return null;
    }

    public static String getInput(String formula) {
        Matcher matcher = PATTERN_INPUT.matcher(formula);

        if (matcher.find()) {
            return matcher.group(DELIMITER_GROUP);
        }

        throw new IllegalArgumentException("커스텀 계산 식이 아닙니다.");
    }
}
