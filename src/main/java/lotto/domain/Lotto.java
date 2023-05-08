package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    protected List<Integer> numbers;

    public Lotto() {
        List<Integer> randomNumbers = getRandomNumbers();
        numbers = sorted(randomNumbers);

    }

    private List<Integer> getRandomNumbers() {
        List<Integer> availableNumbers = new ArrayList<>();

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            availableNumbers.add(i);
        }

        Collections.shuffle(availableNumbers);
        return availableNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    private List<Integer> sorted(List<Integer> randomNumbers) {
        return randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto(List<Integer> inNumbers) {
        validateNumbers(inNumbers);
        numbers = sorted(inNumbers);
    }

    private void validateNumbers(List<Integer> inNumbers) {
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

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(num -> num.toString())
                .collect(Collectors.joining(", ","[","]"));
    }
}
