package me.daeho.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleLottoNumber implements RandomLottoNumberRule {
    private static final int NUMBER_COUNT = 6;
    private final List<LottoNumber> availableNumbers;

    private ShuffleLottoNumber(List<LottoNumber> availableNumbers) {
        this.availableNumbers = availableNumbers;
    }

    public static ShuffleLottoNumber create(List<LottoNumber> availableNumbers) {
        return new ShuffleLottoNumber(availableNumbers);
    }

    public List<LottoNumber> make() {
        Collections.shuffle(availableNumbers);

        return IntStream.range(0, NUMBER_COUNT)
                .mapToObj(availableNumbers::get)
                .collect(Collectors.toList());
    }
}

