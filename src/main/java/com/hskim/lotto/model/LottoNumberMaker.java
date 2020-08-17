package com.hskim.lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
public interface LottoNumberMaker {
    List<Integer> NUMBER_POOL = makeNumberPool();

    static List<Integer> makeNumberPool() {
        return IntStream
                .rangeClosed(LottoNumber.LOW_BOUND,  LottoNumber.UPPER_BOUND)
                .boxed()
                .collect(Collectors.toList());
    }

    List<Integer> makeNumbers(int size);
}
