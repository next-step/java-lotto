package com.hskim.lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberMaker implements NumberMaker {

    @Override
    public List<Integer> makeNumbers(List<Integer> numberPool, int size) {
        Collections.shuffle(numberPool);

        return numberPool.stream()
                .limit(size)
                .sorted()
                .collect(Collectors.toList());
    }
}
