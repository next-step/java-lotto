package calculator;

import java.util.stream.Stream;

public class StringCalculator {

    private static final String EMPTY_STRING = "";
    private static final String REGEX_SPLIT_STRING = ":|,";
    private static final int ZERO = 0;

    public int splitAndSum(String string) {

        if (string == null | string.equals(EMPTY_STRING)) {
            return ZERO;
        }

        return Stream.of(string.split(REGEX_SPLIT_STRING)).mapToInt(Integer::parseInt).sum();
    }
}
