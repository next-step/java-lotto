package lotto.domain.generator;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberCache;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    private static final int LOTTO_SIZE = 6;

    @Override
    public HashSet<LottoNumber> generate() {
        List<LottoNumber> numbers = LottoNumberCache.LOTTO_NUMBER_CACHE;
        Collections.shuffle(numbers);
        return new HashSet<>(numbers.subList(0, LOTTO_SIZE));
    }
}
