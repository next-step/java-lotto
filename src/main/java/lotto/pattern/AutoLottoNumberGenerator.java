package lotto.pattern;

import lotto.Lotto;
import lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberGenerator implements LottoNumberGenerateStrategy {

    private AutoLottoNumberGenerator() {
    }

    private static final AutoLottoNumberGenerator INSTANCE = new AutoLottoNumberGenerator();

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
        return lottoNumberRange.subList(0, Lotto.LOTTO_NUMBER_SIZE);
    }
}
