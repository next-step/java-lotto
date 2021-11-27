package lotto.utils;

import addcalculator.exception.NotInstanceException;
import lotto.domain.value.Price;
import lotto.domain.value.WinningNumbers;
import lotto.exception.EmptySourceException;
import lotto.exception.InvalidValueException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputUtils {
    private static final String SEPARATOR = ", ";

    private InputUtils() {
        throw new NotInstanceException();
    }

    public static Price createPrice(String input) {
        validatePrice(input);
        return Price.of(input);
    }

    public static WinningNumbers createWinningNumbers(String input) {
        validateEmpty(input);

        List<String> stringNumbers = Arrays.asList(input.split(SEPARATOR));

        validateNumber(stringNumbers);

        List<Integer> numbers = stringNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return WinningNumbers.of(numbers);
    }

    private static void validatePrice(String input) {
        validateEmpty(input);
        validateIsDigit(input);
    }

    private static void validateEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new EmptySourceException();
        }
    }

    private static void validateIsDigit(String input) {
        boolean isDigit = input.chars()
                .allMatch(Character::isDigit);

        if (!isDigit) {
            throw new InvalidValueException();
        }
    }

    private static void validateNumber(List<String> winningNumbers) {
        winningNumbers.forEach(InputUtils::validateIsDigit);
    }
}
