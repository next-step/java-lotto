package lotto.domain.util;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;

import java.util.Set;

public class PrizeNumberValidator {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private PrizeNumberValidator() {
    }

    public static void validate(Set<Integer> prizeNumbers) {
        if(!validatePrizeNumberSize(prizeNumbers)){
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean validatePrizeNumberSize(Set<Integer> prizeNumbers) {
        return prizeNumbers.size() == 6;
    }
}
