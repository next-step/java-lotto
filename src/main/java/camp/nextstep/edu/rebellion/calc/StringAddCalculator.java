package camp.nextstep.edu.rebellion.calc;

import camp.nextstep.edu.rebellion.calc.util.StringUtil;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_MATCHER = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
    private static final int ZERO = 0;

    private StringAddCalculator() {}

    public static int splitAndSum(String expression) {
        if (StringUtil.isEmpty(expression)) {
            return ZERO;
        }

        return calculation(expression);
    }

    private static int calculation(String expression) {
        return Arrays.stream(makeTokens(expression))
                .mapToInt(StringAddCalculator::convertInteger)
                .sum();
    }

    private static String[] makeTokens(String expression) {
        Matcher matcher = CUSTOM_DELIMITER_MATCHER.matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return expression.split(DEFAULT_DELIMITER);
    }

    private static int convertInteger(String str) {
        int result = Integer.parseInt(str);
        if(result < 0) {
            throw new IllegalArgumentException("음수 입니다");
        }
        return result;
    }
}
