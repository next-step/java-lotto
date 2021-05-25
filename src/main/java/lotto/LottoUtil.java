package lotto;

import lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.WinningNumbers.SPLIT_SYMBOL;

public class LottoUtil {
    private LottoUtil() {
    }

    public static List<LottoNumber> stringNumbersToLottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(SPLIT_SYMBOL))
                .map(String::trim)
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }

}
