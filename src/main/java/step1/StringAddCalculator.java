package step1;

import java.util.List;

public class StringAddCalculator {

    private final PositiveNumber positiveNumber;
    private final StringParser stringParser;

    public StringAddCalculator(PositiveNumber positiveNumber, StringParser stringParser) {
        this.positiveNumber = new PositiveNumber();
        this.stringParser = new StringParser();
    }

    public int splitAndSum(String input) {
        if (input.isBlank()) {
            return 0;
        }
        String delimiter = stringParser.setDelimiter(input);
        String[] parse = stringParser.parse(delimiter);
        List<Integer> numbers = positiveNumber.toInt(parse);
        return positiveNumber.add(numbers);
    }
}
