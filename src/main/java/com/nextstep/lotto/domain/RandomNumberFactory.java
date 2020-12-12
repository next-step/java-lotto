package com.nextstep.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberFactory {
    private static final int LOTTO_MAX_COUNT = 45;
    private static final int LOTTO_START_IDX = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> TOTAL_NUMBERS = Stream.iterate(1, i -> i + 1)
            .limit(LOTTO_MAX_COUNT).collect(Collectors.toList());

    private RandomNumberFactory(){}

    public static List<Integer> createRandomNumbers() {
        List<Integer> shuffleNumbers = getShuffleNumbers();
        Collections.sort(shuffleNumbers);
        return Collections.unmodifiableList(shuffleNumbers);
    }

    private static List<Integer> getShuffleNumbers() {
        Collections.shuffle(TOTAL_NUMBERS);
        return TOTAL_NUMBERS.subList(LOTTO_START_IDX, LOTTO_NUMBER_COUNT);
    }
}
