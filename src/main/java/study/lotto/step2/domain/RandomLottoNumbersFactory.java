package study.lotto.step2.domain;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomLottoNumbersFactory implements LottoNumbersFactory {
    private static final int INCLUSIVE_MINIMUM_LOTTO_NUMBER = 1;
    private static final int EXCLUSIVE_MAXIMUM_LOTTO_NUMBER = 46;
    private static final int LOTTO_NUMBER_SIZE = 6;

    @Override
    public LottoNumbers create() {
        return new LottoNumbers(lottoNumbers());
    }

    private static Set<LottoNumber> lottoNumbers() {
        return ThreadLocalRandom.current().ints(INCLUSIVE_MINIMUM_LOTTO_NUMBER, EXCLUSIVE_MAXIMUM_LOTTO_NUMBER)
                .distinct()
                .limit(LOTTO_NUMBER_SIZE)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }
}
