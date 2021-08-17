package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.exception.NumbersIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LENGTH_OF_NUMBERS = 6;

    private final List<Integer> numbers;

    private Ticket(List<Integer> numbers) {
        Collections.sort(numbers);
        validateLengthOfNumbers(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    public static Ticket of(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public static Ticket of(String numbersString) {
        return new Ticket(createNumbersFromString(numbersString));
    }

    private static List<Integer> createNumbersFromString(String numbersString) {
        return Arrays.stream(numbersString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int countMatchingNumbers(Ticket winningTicket) {
        return (int) numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateOutOfRange(List<Integer> numbers) {
        if (numbers.get(0) < MIN_NUMBER || numbers.get(numbers.size()-1) > MAX_NUMBER) {
            throw new NumbersIllegalArgumentException("지정 가능 숫자 범위 초과. 범위 : " + MIN_NUMBER + " ~ " + MAX_NUMBER);
        }
    }

    private void validateLengthOfNumbers(List<Integer> numbers) {
        if (numbers.size() != LENGTH_OF_NUMBERS) {
            throw new NumbersIllegalArgumentException("입력 숫자 개수 미달 or 초과. 지정 개수 : " + LENGTH_OF_NUMBERS);
        }
    }
}
