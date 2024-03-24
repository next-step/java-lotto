package lotto.domain.lotto.strategy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.domain.lotto.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.lotto.LottoNumber.MIN_LOTTO_NUMBER;

public abstract class LottoGeneratingStrategy {
    protected static final int START_OF_RANGE = 0;
    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .mapToObj(LottoNumber::valueOf)
            .collect(Collectors.toList());

    public abstract Lottos lottos(int totalNumberOfLottoToPurchase);

    protected Lotto automaticLotto() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        List<LottoNumber> newLottoNumbers = LOTTO_NUMBER_POOL.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());

        return Lotto.valueOf(newLottoNumbers);
    }
}
