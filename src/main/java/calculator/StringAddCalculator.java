package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    private final Parser parser;

    public StringAddCalculator() {
        this.parser = new Parser();
    }

    public int sum(String input) {
        String[] stringNumbers = parser.parse(input);

        int[] numbers = convertInt(stringNumbers);

        return Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
    }

    private int[] convertInt(String[] stringNumbers) {
        try {
            return Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("``stringNumbers` is must be number format");
        }
    }
}
