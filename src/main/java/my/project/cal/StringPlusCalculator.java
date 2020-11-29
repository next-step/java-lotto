package my.project.cal;

import my.project.constants.Delimiters;
import my.project.constants.Matchers;
import my.project.exception.CalException;
import my.project.messages.ExceptionMessages;
import my.project.utils.ArrayUtils;
import my.project.utils.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created : 2020-11-20 오전 9:30
 * Developer : Seo
 */
public class StringPlusCalculator {
    public static final String INPUT_HAS_NEGATIVE = "0 혹은 음수가 포함되어 있습니다.";

    public int sumStringByDelimiter(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }
        if (hasCustomDelimiter(input)) {
            return sumCustom(input);
        }
        if (ArrayUtils.isStringAlone(input)) {
            return Integer.parseInt(input);
        }

        return sum(input.split(Delimiters.DELIMITER));
    }

    private void hasNegative(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new CalException(INPUT_HAS_NEGATIVE);
        }
    }

    private Matcher localMatcher(String input) {
        return Pattern.compile(Delimiters.CUSTOM_PATTERN_DELIMITER).matcher(input);
    }

    private boolean hasCustomDelimiter(String input) {
        return localMatcher(input).find();
    }

    private int sumCustom(String input) {
        Matcher matcher = localMatcher(input);
        if (matcher.find()) {
            return sum(matcher.group(Matchers.TARGET).split(matcher.group(Matchers.DELIMITER)));
        }
        return 0;
    }

    private int sum(String[] tokens) {
        int sum = 0;
        for (String s : tokens) {
            hasNegative(s);
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}
