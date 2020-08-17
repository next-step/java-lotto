package com.hskim.lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLottoNumberMaker implements LottoNumberMaker {

    @Override
    public List<Integer> makeNumbers(int size) {
        Collections.shuffle(NUMBER_POOL);

        return NUMBER_POOL.stream()
                .limit(size)
                .sorted()
                .collect(Collectors.toList());
    }
}
