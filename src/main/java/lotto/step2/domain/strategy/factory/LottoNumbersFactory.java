package lotto.step2.domain.strategy.factory;

import lotto.step2.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {
    private static class LottoNumbersHolder {
        private static final List<LottoNumber> LOTTO_NUMBERS = lottoNumbersCreate();
    
        private static List<LottoNumber> lottoNumbersCreate() {
            return IntStream.rangeClosed(1, 45)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());
        }
    }
    
    public static List<LottoNumber> getInstance() {
        return LottoNumbersHolder.LOTTO_NUMBERS;
    }
}
