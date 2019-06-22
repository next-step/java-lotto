package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBERS =
            IntStream.rangeClosed(Env.MIN_LOTTO_NUMBER, Env.MAX_LOTTO_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public Lotto generate() {
        shuffle();

        return new Lotto(randomLottoNumbers());
    }

    private void shuffle() {
        Collections.shuffle(LOTTO_NUMBERS);
    }

    private Set<LottoNumber> randomLottoNumbers() {
        return LOTTO_NUMBERS.stream()
                .limit(Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO)
                .collect(Collectors.toUnmodifiableSet());
    }
}
