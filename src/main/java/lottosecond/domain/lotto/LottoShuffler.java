package lottosecond.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShuffler implements CustomShuffle {

    private final List<LottoNumber> defaultLottoNumbers =  IntStream.range(1, 46)
            .boxed()
            .map(LottoNumber::of)
            .collect(Collectors.toList());

    @Override
    public List<LottoNumber> makeShuffle() {
        Collections.shuffle(defaultLottoNumbers, new Random(System.currentTimeMillis()));
        return defaultLottoNumbers.stream().limit(Lotto.LOTTO_SIZE).collect(Collectors.toList());
    }
}
