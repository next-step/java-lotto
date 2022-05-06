package lotto.pattern;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberGenerator implements LottoNumberGenerateStrategy {
    private static final int LOTTO_NUMBER_FIRST_INDEX = 0;
    private static final AutoLottoNumberGenerator INSTANCE = new AutoLottoNumberGenerator();

    private AutoLottoNumberGenerator() {
    }

    public static AutoLottoNumberGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public List<LottoNumber> generate() {
        List<LottoNumber> lottoNumberRange = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER , LottoNumber.LOTTO_MAX_NUMBER)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumberRange);
        return lottoNumberRange.subList(LOTTO_NUMBER_FIRST_INDEX, Lotto.LOTTO_NUMBER_SIZE);
    }
}
