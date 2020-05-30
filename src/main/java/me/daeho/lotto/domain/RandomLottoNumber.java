package me.daeho.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumber implements LottoNumberRule {
    private static final int NUMBER_COUNT = 6;
    private final List<Integer> availableNumbers;

    private RandomLottoNumber(List<Integer> availableNumbers) {
        this.availableNumbers = availableNumbers;
    }

    public static RandomLottoNumber create(List<Integer> availableNumbers) {
        return new RandomLottoNumber(availableNumbers);
    }

    public List<LottoNumber> make() {
        Collections.shuffle(availableNumbers);

        return IntStream.range(0, NUMBER_COUNT)
                .mapToObj(availableNumbers::get)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}

