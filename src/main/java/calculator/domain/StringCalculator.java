package calculator.domain;

public class StringCalculator {

    private static final Number ZERO = Number.from(0);

    private final Numbers numbers;

    private StringCalculator(final Numbers numbers) {
        this.numbers = numbers;
    }

    public static StringCalculator from(final Numbers numbers) {
        return new StringCalculator(numbers);
    }

    public Number calculate() {
        return numbers.getValues().stream()
            .reduce(ZERO, Number::add);
    }
}
