package calculator;

public class StringAddCalculator {

    private final PatternReader patternReader;

    public StringAddCalculator(final PatternReader patternReader) {
        this.patternReader = patternReader;
    }

    public int sum(final String pattern) {
        Numbers numbers = patternReader.read(pattern);
        return numbers.sum()
                .value();
    }
}
