package lotto.step2.domain.factory;

import lotto.step2.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {
    private static class LottoNumbersHolder {
        private static final List<LottoNumber> LOTTO_NUMBERS = lottoNumbersCreate();
        private static final int LOTTO_MAX_NUMBER = 45;
        private static final int LOTTO_MIN_NUMBER = 1;
    
        private static List<LottoNumber> lottoNumbersCreate() {
            return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());
        }
    }
    
    public static List<LottoNumber> getInstance() {
        return LottoNumbersHolder.LOTTO_NUMBERS;
    }
}
