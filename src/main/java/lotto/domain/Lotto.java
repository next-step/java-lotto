package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private List<Integer> numbers;

    public Lotto(ArrayList<Integer> inNumbers) {
        validateNumbers(inNumbers);
        numbers = inNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateNumbers(ArrayList<Integer> inNumbers) {
        if (inNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("Expected %d numbers, but received %d.", NUMBER_COUNT, inNumbers.size()));
        }

        if (inNumbers.stream().anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)) {
            throw new IllegalArgumentException(String.format("Number must be between %d and %d.", MIN_NUMBER, MAX_NUMBER));
        }
    }

    public boolean equals(ArrayList<Integer> inNumbers) {
        return numbers.equals(inNumbers);
    }
}
