package calculator.model;

import calculator.cache.MatcherCache;
import calculator.model.seperator.BasicSeparator;
import calculator.model.seperator.CustomSeparator;
import calculator.model.seperator.Separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorFactory {
    private static final String EXPRESSION_REGEX = "//(.)\n(.*)";

    public static Separator create(String input) {
        if (MatcherCache.hasMatcher(input)) {
            return new CustomSeparator(MatcherCache.getMatcher(input).group(1));
        }

        Matcher matcher = Pattern.compile(EXPRESSION_REGEX).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            MatcherCache.putMatcher(input, matcher);
            return new CustomSeparator(customDelimiter);
        }

        return BasicSeparator.of();
    }

}
