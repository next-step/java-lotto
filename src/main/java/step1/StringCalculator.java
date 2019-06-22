package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int VALUE_FOR_EMPTY_INPUT = 0;
    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";


    public int calculate(String inputString) {

        if (checkIfEmpty(inputString)) {
            return VALUE_FOR_EMPTY_INPUT;
        }

        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(inputString);
        if (m.find()) {
            String customSeparator = m.group(1);
            String[] tokens = m.group(2).split(customSeparator);

            return Arrays
                    .stream(tokens)
                    .map(Integer::parseInt)
                    .reduce((i1, i2) -> i1 + i2)
                    .get();
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
