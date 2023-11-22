package lotto.domain;

import lotto.exceptions.InvalidLottoNumbersException;

import java.util.List;

public class Validator {

    private static final int NUMBERS_SIZE = 6;

    public static void validateLottoNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBERS_SIZE) {
            throw new InvalidLottoNumbersException();
        }
    }
}
