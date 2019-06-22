package step1;

import java.util.Arrays;

public class StringCalculator {
    private static final int VALUE_FOR_EMPTY_INPUT = 0;
    private static final String DEFAULT_SEPARATOR = "[,:]";


    public int calculate(String inputString) {

        if (checkIfEmpty(inputString)) {
            return VALUE_FOR_EMPTY_INPUT;
        }
        if (!inputString.contains(",") && !inputString.contains(":")) {
            return Integer.parseInt(inputString);
        }

        return Arrays
                .stream(inputString.split(DEFAULT_SEPARATOR))
                .map(Integer::parseInt)
                .reduce((i1, i2) -> i1 + i2)
                .get();
    }

    private boolean checkIfEmpty(String inputString) {
        return inputString == null || "".equals(inputString);
    }
}
