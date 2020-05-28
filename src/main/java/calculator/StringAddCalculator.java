package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private final Parser parser;

    public StringAddCalculator() {
        this.parser = new Parser();
    }

    public int sum(String input) {
        int[] numbers = parser.parseToIntArray(input);

        return Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
    }
}
