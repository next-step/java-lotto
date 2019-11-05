package com.seok2.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomLottoStrategy implements LottoStrategy {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
        .mapToObj(LottoNumber::of)
        .collect(toList());

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        return LOTTO_NUMBER_POOL.stream().limit(LOTTO_COUNT).collect(Collectors.toList());
    }
}
