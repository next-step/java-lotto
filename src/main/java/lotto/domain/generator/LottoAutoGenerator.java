package lotto.domain.generator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;

public class LottoAutoGenerator implements LottoGenerator {

    private List<LottoNumber> lottoNumberPool;

    public LottoAutoGenerator() {
        this.lottoNumberPool = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    }

    @Override
    public LottoNumbers generateNumbers() {
        Collections.shuffle(lottoNumberPool);
        return new LottoNumbers(lottoNumberPool.stream()
            .limit(LOTTO_NUMBERS)
            .collect(Collectors.toList()));
    }

}
