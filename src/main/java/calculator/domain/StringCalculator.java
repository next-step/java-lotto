package calculator.domain;

public class StringCalculator {

    private final Numbers numbers;

    private StringCalculator(final Numbers numbers) {
        this.numbers = numbers;
    }

    public static StringCalculator from(final Numbers numbers) {
        return new StringCalculator(numbers);
    }

    public Number calculate() {
        return numbers.addAll();
    }
}
