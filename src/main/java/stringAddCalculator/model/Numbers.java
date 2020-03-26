package stringAddCalculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers create(final String[] numbersString) {
        List<Integer> numbers = Arrays.stream(numbersString)
                .mapToInt(Numbers::parserInt)
                .boxed()
                .collect(Collectors.toList());

        return new Numbers(numbers);
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int parserInt(final String numberString) {
        int number = Integer.parseInt(numberString);

        if (number < 0) {
            throw new RuntimeException("number must be greater than zero.");
        }

        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Numbers)) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
