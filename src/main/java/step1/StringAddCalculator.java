package step1;

import step1.constants.Constants;
import step1.domain.Numbers;
import step1.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(final String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }
        Numbers numbers = Numbers.from(getInputs(input));
        return numbers.sum();
    }

    private static List<String> getInputs(final String input) {
        Matcher m = Pattern.compile(Constants.CUSTOM_SEPARATOR_PATTERN).matcher(input);
        if (m.find()) {
            return Arrays.asList(StringUtils.split(m.group(2), m.group(1)));
        }
        return Arrays.asList(StringUtils.split(input, Constants.SEPARATOR_PATTERN));
    }
}
