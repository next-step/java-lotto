package step1;

import java.util.Arrays;

public class StringCalculator {
    private static final int ZERO = 0;
    private static final String DEFAULT_SEPARATOR = ",";

    public int calculate(String inputString) {
        if (inputString == null || "".equals(inputString)) {
            return ZERO;
        }
        if (!inputString.contains(DEFAULT_SEPARATOR)) {
            return Integer.parseInt(inputString);
        }
        return Arrays
                .stream(inputString.split(DEFAULT_SEPARATOR))
                .map(Integer::parseInt)
                .reduce((i1, i2) -> i1 + i2)
                .get();
    }
}
