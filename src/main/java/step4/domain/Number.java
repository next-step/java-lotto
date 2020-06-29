package step4.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/*
 * LOTTO GAME
 * Number
 * ver. 1.0
 * 2020.05.31
 */
public class Number {

    private static final Pattern patternNumbersOnly = Pattern.compile("^[-+]?[0-9]+$");

    private Number() {
        // block
    }

    public static void checkNumber(String inputString) {
        if (Objects.isNull(inputString) || !patternNumbersOnly.matcher(inputString).matches()) {
            throw new IllegalArgumentException("Found a not number(s).");
        }
    }

    public static void checkNumber(String[] inputString) {
        Arrays.stream(inputString)
                .forEach(string -> {
                            checkMatchingPatternNumberOnly(string);
                        }
                );
    }

    private static void checkMatchingPatternNumberOnly(String string) {
        if (!patternNumbersOnly.matcher(string).matches()) {
            throw new IllegalArgumentException("Found a not number(s).");
        }
    }

    public static void checkNotNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
    }

    public static void checkNotNumber(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
        if (Integer.valueOf(number) < 0) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
    }

    public static void checkNotNumber(String[] numbers) {
        long count = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .filter(number -> number < 0)
                .count();
        // find a negative number(s).
        if (count > 0) {
            throw new IllegalArgumentException("Found a Illegal Argument(s).");
        }
    }

}
