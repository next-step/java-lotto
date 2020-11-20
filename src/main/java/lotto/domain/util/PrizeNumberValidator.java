package lotto.domain.util;

import lotto.domain.exception.NotValidLottoNumberException;
import lotto.domain.exception.ErrorMessage;

import java.util.HashSet;

public class PrizeNumberValidator {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private PrizeNumberValidator() {
    }

    public static void validate(HashSet<Integer> prizeNumbers) {
        if(!validatePrizeNumberSize(prizeNumbers)){
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean validatePrizeNumberSize(HashSet<Integer> prizeNumbers) {
        return prizeNumbers.size() == 6;
    }
}
