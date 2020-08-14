package calculator;


import calculator.cache.MatcherCache;
import calculator.model.Expression;
import calculator.model.seperator.Separator;
import calculator.model.SeparatorFactory;

import java.util.regex.Matcher;

public class StringAddCalculator {

    public static int calculate(String input) {
        Separator separator = SeparatorFactory.create(input);
        Expression expression = new Expression(separator.splitByDelimiter(getExpressionString(input)));

        return expression.addNumbers();
    }

    private static String getExpressionString(String input) {
        if (!MatcherCache.hasMatcher(input)) {
            return input;
        }

        Matcher matcher = MatcherCache.getMatcher(input);
        return matcher.group(2);
    }

}
