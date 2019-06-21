package camp.nextstep.edu.calculator;

import java.util.stream.Stream;

public class StringAdditionCalculator {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final String REGEX_DELIMITERS = "[" + DELIMITER_COMMA + DELIMITER_COLON + "]";
    private static final int ZERO = 0;

    public int calculate(String input) {
        if (input == null) {
            return ZERO;
        }
        if (EMPTY_STRING.equals(input)) {
            return ZERO;
        }
        if (this.hasOnlyOneNumber(input)) {
            return Integer.parseInt(input);
        }
        final String[] splitString = input.split(REGEX_DELIMITERS);
        return Stream.of(splitString)
                .map(Integer::parseInt)
                .reduce(ZERO, Integer::sum);
    }

    private boolean hasOnlyOneNumber(String input) {
        final boolean containsComma = input.contains(DELIMITER_COMMA);
        final boolean containsColon = input.contains(DELIMITER_COLON);
        return !containsComma && !containsColon;
    }

}
