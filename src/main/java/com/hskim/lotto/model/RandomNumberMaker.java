package com.hskim.lotto.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberMaker implements NumberMaker {
    private static final Random random = new Random();

    @Override
    public List<String> makeNumbers(int lowBound, int upperBound, int size) {
        return random.ints(lowBound, upperBound + 1)
                .boxed()
                .distinct()
                .limit(size)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
