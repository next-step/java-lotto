package camp.nextstep.edu.calculator;

import java.util.stream.Stream;

public class StringAdditionCalculator {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITER_COMMA = ",";
    private static final String DELIMITER_COLON = ":";
    private static final int ZERO = 0;

    public int calculate(String input) {
        if (input == null) {
            return ZERO;
        }
        if (EMPTY_STRING.equals(input)) {
            return ZERO;
        }
        if (!input.contains(DELIMITER_COMMA) && !input.contains(DELIMITER_COLON)) {
            return Integer.parseInt(input);
        }
        return Stream.of(input.split(("[" + DELIMITER_COMMA + DELIMITER_COLON + "]")))
                .map(Integer::parseInt)
                .reduce(ZERO, Integer::sum);
    }

}
