package calculator;

public class StringAdderCalculator {
    private PositiveNumbers positiveNumbers;

    public StringAdderCalculator(String input) {
        StringParser stringParser = new StringParser(input);
        positiveNumbers = stringParser.parseByDelimiter();
    }

    public PositiveNumber calculate() {
        int sum = positiveNumbers.getPositiveNumbers()
                .stream()
                .mapToInt(PositiveNumber::getNumber)
                .sum();
        return new PositiveNumber(sum);
    }
}
