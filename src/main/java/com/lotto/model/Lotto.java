package com.lotto.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    @Override
    public String toString() {
        String numberList = numbers.stream().map(String::valueOf).collect(Collectors.joining(","));
        return "[" + numberList + "]";
    }
}
