package com.hskim.lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class FixedNumberMaker implements NumberMaker {
    @Override
    public List<Integer> makeNumbers(List<Integer> numberPool, int size) {

        return numberPool.stream()
                .limit(size)
                .collect(Collectors.toList());
    }
}
