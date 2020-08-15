package com.hskim.lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedNumberMaker implements NumberMaker {
    @Override
    public List<String> makeNumbers(int lowBound, int upperBound, int size) {
        return IntStream.rangeClosed(lowBound, upperBound)
                .boxed()
                .limit(size)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
