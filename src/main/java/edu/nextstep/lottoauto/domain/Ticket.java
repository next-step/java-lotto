package edu.nextstep.lottoauto.domain;

import java.util.Collections;
import java.util.List;

public class Ticket {

    private static final int MIN_NUMBERS = 1;
    private static final int MAX_NUMBERS = 45;
    private static final int NUMBER_OF_NUMBERS = 6;

    private final List<Integer> numbers;

    private Ticket(List<Integer> numbers) {
        Collections.sort(numbers);
        validateNumOfNumbers(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    private void validateOutOfRange(List<Integer> numbers) {
        if (numbers.get(0) < MIN_NUMBERS || numbers.get(numbers.size()-1) > MAX_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumOfNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    public static Ticket of(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
