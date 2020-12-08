package calculator;

public class StringAddCalculator {

    private final PatternReader patternReader;

    public StringAddCalculator(final PatternReader patternReader) {
        this.patternReader = patternReader;
    }

    public int sum(final String value) {
        Numbers numbers = patternReader.read(value);
        return numbers.sum()
                .value();
    }
}
