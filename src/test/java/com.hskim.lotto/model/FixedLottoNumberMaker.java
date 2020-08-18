package com.hskim.lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class FixedLottoNumberMaker implements LottoNumberMaker {
    @Override
    public List<Integer> makeNumbers(int size) {

        return NUMBER_POOL.stream()
                .limit(size)
                .collect(Collectors.toList());
    }
}
