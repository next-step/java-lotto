package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Validator.*;
import static lotto.domain.Lotto.*;

public class WinningNumbers {
    private static final String WRONG_WINNING_NUMBERS_MESSAGE = "잘못된 당첨 번호입니다.";
    private static final String COMMA_BLANK_DELIMITER = ", ";

    private final List<Integer> winningNumberList;

    private WinningNumbers(String winningNumbers) {
        validateWinningNumbers(winningNumbers);
        validateWinningNumbersSize(winningNumbers);

        this.winningNumberList = Arrays.stream(winningNumbers.split(COMMA_BLANK_DELIMITER))
                .map(winningNumber -> {
                    validateWinningNumber(winningNumber);
                    return Integer.parseInt(winningNumber);
                })
                .collect(Collectors.toList());
    }

    public static WinningNumbers valueOf(String winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    private void validateWinningNumbers(String winningNumbers) {
        if(!isNonBlank(winningNumbers)) {
            throw new IllegalArgumentException(WRONG_WINNING_NUMBERS_MESSAGE);
        }
    }

    private void validateWinningNumbersSize(String winningNumbers) {
        if(winningNumbers.split(COMMA_BLANK_DELIMITER).length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_WINNING_NUMBERS_MESSAGE);
        }
    }

    private void validateWinningNumber(String winningNumber) {
        if(!isPositiveInteger(winningNumber) || !isInRange(Integer.parseInt(winningNumber), MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(WRONG_WINNING_NUMBERS_MESSAGE);
        }
    }

    public List<Integer> winningNumbers() {
        return winningNumberList;
    }
}
