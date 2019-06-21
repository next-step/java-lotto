package camp.nextstep.edu.calculator;

import java.util.stream.Stream;

public class StringAdditionCalculator {

    private static final String EMPTY_STRING = "";
    private static final int ZERO = 0;

    public int calculate(String input) {
        if (input == null) {
            return ZERO;
        }
        if (EMPTY_STRING.equals(input)) {
            return ZERO;
        }
        if (!input.contains(",")) {
            return Integer.parseInt(input);
        }
        return Stream.of(input.split(","))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

}
