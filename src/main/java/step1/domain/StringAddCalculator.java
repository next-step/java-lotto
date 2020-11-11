package step1.domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int CALCULATOR_OBJECT = 2;
    private static final int CALCULATOR_DELIMITER = 1;
    private static final String NO_PATTERN_DELIMITER = "[:,]";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (isNull(input) || isEmpty(input)) {
            return 0;
        }
        return sumStringArray(getNumbers(input));
    }


    private static String[] getNumbers(String input) {
        Matcher m = getMatcher(input);
        if (m.find()) {
            return m.group(CALCULATOR_OBJECT).split(m.group(CALCULATOR_DELIMITER));

        }
        return input.split(NO_PATTERN_DELIMITER);

    }

    private static Matcher getMatcher(String input) {
        return pattern.matcher(input);
    }


    private static int sumStringArray(String[] split) {
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .mapToInt(StringAddCalculator::getIntValue)
                .sum();
    }

    private static int getIntValue(Integer input) {
        validNumZero(input);
        return input;
    }


    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }


    private static void validNumZero(int i) {
        if (i < 0) {
            throw new RuntimeException("익셉션");
        }
    }
}
