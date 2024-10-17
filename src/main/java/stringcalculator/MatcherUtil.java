package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {
    public static Matcher customMatcher(String operatorRegex, String mathExpression) {
        Pattern pattern = Pattern.compile(operatorRegex);
        return pattern.matcher(mathExpression);
    }
}
