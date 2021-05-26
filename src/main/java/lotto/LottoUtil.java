package lotto;

import lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.common.LottoConstants.SPLIT_SYMBOL;

public class LottoUtil {
    private LottoUtil() {
    }

    public static List<LottoNumber> stringNumbersToLottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(SPLIT_SYMBOL))
                .map(String::trim)
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }

    public static void validateLottoNumbersSize(List<LottoNumber> lottoNumbers, String message) {
        if (!(new HashSet<>(lottoNumbers).size() == LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException(message);
        }
    }

}
