package com.lotto.domain;

import java.util.*;

public class Lottery {

    private static final int START_NUMBER = 1;
    private static final int TOTAL_NUMBER_COUNT = 45;
    private static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) throws IllegalStateException {
        validateNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) throws IllegalStateException {
        if (new HashSet<>(numbers).size() != NUMBER_COUNT
                || numbers.stream().anyMatch(number -> number < START_NUMBER || number > TOTAL_NUMBER_COUNT)) {
            throw new IllegalStateException();
        }
    }

    public int compareMatchingNumbers(Lottery lottery) {
        List<Integer> totalNumbers = new ArrayList<>();
        totalNumbers.addAll(numbers);
        totalNumbers.addAll(lottery.numbers);
        return NUMBER_COUNT * 2 - new HashSet<>(totalNumbers).size();
    }

    @Override
    public String toString() {
        String s = this.numbers.stream()
                .map(number -> Integer.toString(number))
                .reduce((prev, next) -> String.format("%2s, %2s", prev, next))
                .orElseThrow(IllegalStateException::new);
        return String.format("[%s]", s);
    }
}
