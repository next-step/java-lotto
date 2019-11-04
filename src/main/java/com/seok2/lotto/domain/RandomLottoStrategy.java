package com.seok2.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomLottoStrategy implements LottoStrategy {

    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(1,45)
            .mapToObj(LottoNumber::new)
            .collect(toList());

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        return LOTTO_NUMBER_POOL.stream().limit(6).collect(Collectors.toList());
    }
}
