package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private final Parser parser;

    public StringAddCalculator() {
        this.parser = new Parser();
    }

    public int sum(String input) {
        PositiveNumber[] numbers = parser.parseToPositiveNumber(input);

        return Arrays.stream(numbers).mapToInt(PositiveNumber::getValue).reduce(ZERO, Integer::sum);
    }
}
