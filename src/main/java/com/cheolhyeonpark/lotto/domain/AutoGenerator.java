package com.cheolhyeonpark.lotto.domain;

import java.util.*;
import java.util.stream.IntStream;

public class AutoGenerator {

    private final List<Integer> numbers = new ArrayList<>();

    public AutoGenerator() {
        IntStream.rangeClosed(1, 45).forEach(numbers::add);
    }

    public List<Integer> generate() {
        Collections.shuffle(numbers);
        List<Integer> pickedNumbers = numbers.subList(0, 5);
        Collections.sort(pickedNumbers);
        return pickedNumbers;
    }
}
