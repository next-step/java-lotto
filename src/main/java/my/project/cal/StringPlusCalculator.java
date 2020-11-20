package my.project.cal;

import my.project.messages.ExceptionMessages;
import my.project.utils.ArrayUtils;
import my.project.constants.Delimiters;
import my.project.utils.StringUtils;
import my.project.exception.CalException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created : 2020-11-20 오전 9:30
 * Developer : Seo
 */
public class StringPlusCalculator {

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

    private boolean hasNegative(String input) {
        return Integer.parseInt(input) < 0;
    }

    private Matcher localMatcher(String input) {
        return Pattern.compile(
                    Delimiters.CUSTOM_PREFIX_DELIMITER + "(.)" + Delimiters.CUSTOM_SUFFIX_DELIMITER + "(.*)")
                .matcher(input);
    }

    private boolean hasCustomDelimiter(String input) {
        return localMatcher(input).find();
    }

    private int sumCustom(String input) {
        Matcher matcher = localMatcher(input);
        if (matcher.find()) {
            return sum(matcher.group(2).split(matcher.group(1)));
        }
        return 0;
    }

    private int sum(String[] tokens) {
        int sum = 0;
        for (String s : tokens) {
            if (hasNegative(s)) {
                throw new CalException(ExceptionMessages.INPUT_HAS_NEGATIVE);
            }
            sum += Integer.parseInt(s);
        }
        return sum;
    }

}
