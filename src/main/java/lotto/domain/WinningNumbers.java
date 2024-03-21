package lotto.domain;

import lotto.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.Validator.isNonBlank;
import static lotto.Validator.isPositiveInteger;
import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;

public class WinningNumbers {
    private static final String WRONG_WINNING_NUMBERS_MESSAGE = "(%s): 잘못된 당첨 번호입니다.";
    private static final String COMMA_BLANK_DELIMITER = ", ";

    private final Set<LottoNumber> winningNumbers;

    private WinningNumbers(String winningNumberInput) {
        validateWinningNumbers(winningNumberInput);
        validateNumberOfWinningNumbers(winningNumberInput);

        this.winningNumbers = Arrays.stream(winningNumberInput.split(COMMA_BLANK_DELIMITER))
                .map(lottoNumber -> LottoNumber.valueOf(Integer.parseInt(lottoNumber)))
                .collect(Collectors.toUnmodifiableSet());
    }

    private void validateWinningNumbers(String winningNumberInput) {
        if (!isNonBlank(winningNumberInput) || winningNumberInput.split(COMMA_BLANK_DELIMITER).length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format(WRONG_WINNING_NUMBERS_MESSAGE, winningNumberInput));
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
        if (!isPositiveInteger(number) || !numberSet.add(Integer.parseInt(number))) {
            throw new IllegalArgumentException(String.format(WRONG_WINNING_NUMBERS_MESSAGE, number));
        }
    }

    public static WinningNumbers valueOf(String winningNumberInput) {
        return new WinningNumbers(winningNumberInput);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}
