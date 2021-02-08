package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class Validator {

    private Validator() {
    }

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorStrings.ERROR_HINT_NOT_INTEGER);
        }
    }

    public static void isNegative(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException(ErrorStrings.ERROR_HINT_NOT_ALLOWED_NUMBER_SCOPE);
        }
    }

    public static void checkSizeOfLotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorStrings.ERROR_HINT_INPUT_SIX_NUMBER);
        }
    }

    public static void checkDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumbersChecker = new HashSet<>(lottoNumbers);
        if (lottoNumbersChecker.size() != Lotto.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorStrings.ERROR_HINT_NOT_DISTINCT_NUMBER);
        }
    }
}
