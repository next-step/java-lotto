package lotto;

import lotto.model.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.common.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.common.LottoConstants.SPLIT_SYMBOL;

public class LottoUtil {
    private LottoUtil() {
    }

    public static Set<LottoNumber> stringNumbersToLottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(SPLIT_SYMBOL))
                .map(String::trim)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    public static void validateLottoNumbersSize(Set<LottoNumber> lottoNumbers, String message) {
        if (!(lottoNumbers.size() == LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException(message);
        }
    }

}
