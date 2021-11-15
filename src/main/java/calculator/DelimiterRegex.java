package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterRegex {

    private static final String REGEX = "^\\/\\/(.+)(\\\\n)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final Integer DELIMITER_GROUP = 1;

    private DelimiterRegex() {
    }

    public static String getDelimiter(String formula) {
        Matcher matcher = PATTERN.matcher(formula);

        if(matcher.find()) {
            return matcher.group(DELIMITER_GROUP);
        }

        return null;
    }

}
