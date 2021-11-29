package lotto.domain;


import lotto.exception.EmptySourceException;
import lotto.exception.WinningNumberException;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final String SEPARATOR = ", ";
    private static final int NUMBERS_SIZE = 6;
    private static final int NUMBERS_MAX_SIZE = 45;
    private static final int ZERO = 0;
    private static final int VALID_STANDARD = 0;

    private final List<Integer> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        validateNegativeNumber(winningNumbers);
        validateSize(winningNumbers);
        validateNumbers(winningNumbers);

        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    public static WinningNumbers of(String input) {
        validateEmpty(input);

        return new WinningNumbers(convertNumbers(input));
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    private static void validateEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new EmptySourceException();
        }
    }

    private static List<Integer> convertNumbers(String input) {
        List<String> stringNumbers = Arrays.asList(input.split(SEPARATOR));

        return stringNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBERS_SIZE) {
            throw new WinningNumberException();
        }
    }

    private static void validateNumbers(List<Integer> winningNumbers) {
        long wrongNumbersOfDigits = winningNumbers.stream()
                .filter(number -> number > NUMBERS_MAX_SIZE)
                .count();

        if (wrongNumbersOfDigits > VALID_STANDARD) {
            throw new WinningNumberException();
        }
    }

    private static void validateNegativeNumber(List<Integer> winningNumbers) {
        long negativeNumberOfDigits = winningNumbers.stream()
                .filter(number -> number < ZERO)
                .count();

        if (negativeNumberOfDigits > VALID_STANDARD) {
            throw new WinningNumberException();
        }
    }

}
