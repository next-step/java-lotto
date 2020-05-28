package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private final Parser parser;

    public StringAddCalculator() {
        this.parser = new Parser();
    }

    public int sum(String input) {
        String[] splitInput = parser.parse(input);

        int[] numbers = Arrays.stream(splitInput).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
    }
}
