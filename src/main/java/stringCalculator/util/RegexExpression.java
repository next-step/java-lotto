package stringCalculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpression {
    private static final Pattern CUSTOM = Pattern.compile("^//(.)\\\\n");
    private static final String SPLIT_REGEX = ",|:";
    private static final String SPECIAL_CHAR_REGEX = "\\";

    public static String getSplitRegex(String expression) {
        Matcher match =  CUSTOM.matcher(expression);
        if (match.find()) {
            return SPECIAL_CHAR_REGEX + match.group(1);
        }
        return SPLIT_REGEX;
    }

    public static String getReplaceExpression(String expression) {
        Matcher match =  CUSTOM.matcher(expression);
        if (match.find()) {
            return match.replaceFirst("");
        }
        return expression;
    }
}
