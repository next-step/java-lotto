package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.Validator.*;
import static lotto.domain.Lotto.*;

public class WinningNumbers {
    private static final String WRONG_WINNING_NUMBERS_MESSAGE = "잘못된 당첨 번호입니다.";
    private static final String COMMA_BLANK_DELIMITER = ", ";

    private final Set<Integer> winningNumbers;

    private WinningNumbers(String winningNumberInput) {
        validateWinningNumbers(winningNumberInput);
        validateNumberOfWinningNumbers(winningNumberInput);

        this.winningNumbers = Arrays.stream(winningNumberInput.split(COMMA_BLANK_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static WinningNumbers valueOf(String winningNumberInput) {
        return new WinningNumbers(winningNumberInput);
    }


    private void validateWinningNumbers(String winningNumberInput) {
        if (!isNonBlank(winningNumberInput) || winningNumberInput.split(COMMA_BLANK_DELIMITER).length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_WINNING_NUMBERS_MESSAGE);
        }
    }

    private void validateNumberOfWinningNumbers(String winningNumberInput) {
        String[] winningNumberArray = winningNumberInput.split(COMMA_BLANK_DELIMITER);
        Set<Integer> numberSet = new HashSet<>();

        for (String number : winningNumberArray) {
            validateNumber(number, numberSet);
        }
    }

    private void validateNumber(String number, Set<Integer> numberSet) {
        if (!isPositiveInteger(number) || !isInRange(Integer.parseInt(number), MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER) || !numberSet.add(Integer.parseInt(number))) {
            throw new IllegalArgumentException(WRONG_WINNING_NUMBERS_MESSAGE);
        }
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }
}
