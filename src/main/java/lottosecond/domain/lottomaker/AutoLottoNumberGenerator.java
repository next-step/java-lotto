package lottosecond.domain.lottomaker;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {

    private final List<LottoNumber> defaultLottoNumbers =  IntStream.range(1, 46)
            .boxed()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

    @Override
    public List<LottoNumber> makeLottoNumberList() {
        Collections.shuffle(defaultLottoNumbers, new Random(System.currentTimeMillis()));
        return defaultLottoNumbers.stream().limit(Lotto.LOTTO_SIZE).collect(Collectors.toList());
    }
}
