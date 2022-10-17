package lotto.step2.domain.factory;

import lotto.step2.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {
    private static class LottoNumbersHolder {
        private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = lottoNumbersCreate1();
        private static final int LOTTO_MAX_NUMBER = 45;
        private static final int LOTTO_MIN_NUMBER = 1;
    
        private static Map<Integer, LottoNumber> lottoNumbersCreate1() {
            return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                    .boxed()
                    .collect(Collectors.toMap(lottoNumber -> lottoNumber, LottoNumber::new));
        }
    }
    
    private static Map<Integer, LottoNumber> getInstance() {
        return Collections.unmodifiableMap(LottoNumbersHolder.LOTTO_NUMBERS);
    }
    
    public static LottoNumber getLottoNumber(final Integer lottoNumber) {
        return getInstance().get(lottoNumber);
    }
}
