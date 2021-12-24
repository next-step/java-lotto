package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements LottoGenerator {

    private final List<Integer> numbersPool;

    public LottoAutoGenerator() {
        numbersPool = IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Lotto generate() {
        Collections.shuffle(numbersPool);

        List<LottoNumber> lottoNumbers = numbersPool.stream()
                .limit(Lotto.LOTTO_NUMBERS_COUNT)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }
}
