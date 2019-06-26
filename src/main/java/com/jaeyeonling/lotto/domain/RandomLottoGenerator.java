package com.jaeyeonling.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator extends PaymentLottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBERS =
            IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    Lotto generate() {
        shuffle();
        return new Lotto(randomLottoNumbers());
    }

    private void shuffle() {
        Collections.shuffle(LOTTO_NUMBERS);
    }

    private Set<LottoNumber> randomLottoNumbers() {
        return LOTTO_NUMBERS.stream()
                .limit(Lotto.COUNT_OF_LOTTO_NUMBER)
                .collect(Collectors.toUnmodifiableSet());
    }
}
