package com.seok2.lotto.domain.lotto;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AutoLottoStrategy implements LottoStrategy {

    private static final List<Integer> LOTTO_NUMBER_POOL = IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
        .boxed()
        .collect(toList());

    private List<Integer> pool;

    AutoLottoStrategy() {
        this.pool = LOTTO_NUMBER_POOL;
    }

    AutoLottoStrategy(List<Integer> pool) {
        this.pool = pool;
    }

    @Override
    public Lotto generate() {
        return Lotto.auto(makeRandomNumbers());
    }

    private int[] makeRandomNumbers() {
        Collections.shuffle(this.pool);
        return this.pool.stream()
            .limit(Lotto.LENGTH)
            .mapToInt(i -> i)
            .toArray();
    }
}
