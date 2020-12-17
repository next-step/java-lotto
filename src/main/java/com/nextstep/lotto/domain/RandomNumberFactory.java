package com.nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberFactory {
    private static final int LOTTO_START_IDX = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> TOTAL_NUMBERS = Stream.iterate(LottoNumber.MIN, i -> i + 1)
            .limit(LottoNumber.MAX).collect(Collectors.toList());

    private RandomNumberFactory(){}

    public static List<LottoNumber> createRandomNumbers() {
        List<Integer> shuffleNumbers = getShuffleNumbers();
        Collections.sort(shuffleNumbers);
        return Collections.unmodifiableList(toLottoNumberList(shuffleNumbers));
    }

    private static List<LottoNumber> toLottoNumberList(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private static List<Integer> getShuffleNumbers() {
        Collections.shuffle(TOTAL_NUMBERS);
        return new ArrayList<>(TOTAL_NUMBERS.subList(LOTTO_START_IDX, LOTTO_NUMBER_COUNT));
    }
}
