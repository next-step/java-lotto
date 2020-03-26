package stringAddCalculator.model;

import java.util.Arrays;
import java.util.List;
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

    private static int parserInt(String numberString) {
        int number = Integer.parseInt(numberString);

        if (number < 0) {
            throw new RuntimeException("number must be greater than zero.");
        }

        return number;
    }
}
