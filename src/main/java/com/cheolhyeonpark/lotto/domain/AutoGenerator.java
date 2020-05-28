package com.cheolhyeonpark.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AutoGenerator {

    private final List<Integer> numbers = new ArrayList<>();

    public AutoGenerator() {
        IntStream.rangeClosed(1, 45).forEach(numbers::add);
    }

    public LottoNumbers generate() {
        Collections.shuffle(numbers);
        return new LottoNumbers(numbers.subList(0, 6));
    }
}
