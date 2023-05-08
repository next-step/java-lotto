package lotto.domain.generator;

import lotto.domain.LottoConstant;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberCache;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
    @Override
    public HashSet<LottoNumber> generate() {
        List<LottoNumber> numbers = LottoNumberCache.LOTTO_NUMBER_CACHE;
        Collections.shuffle(numbers);
        return new HashSet<>(numbers.subList(0, LottoConstant.LOTTO_SIZE));
    }
}
