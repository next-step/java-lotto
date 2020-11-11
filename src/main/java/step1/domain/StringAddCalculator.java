package step1.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

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

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static int sumStringArray(String[] split) {
        int sum = 0;
        for (String s : split) {
            int i = parseInt(s);
            validNumZero(i);
            sum += i;
        }
        return sum;
    }

    private static void validNumZero(int i) {
        if (i < 0) {
            throw new RuntimeException("익셉션");
        }
    }
}
