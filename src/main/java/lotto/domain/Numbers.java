package lotto.domain;

import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private static final int MAX_SIZE = 6;
    private List<Number> numbers = new ArrayList<>();

    public int size() {
        return numbers.size();
    }

    public int match(Numbers other) {
        return (int) numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    public static Numbers createRandomNumbers() {
        List<Number> numberList = RandomUtil.getRandomInteger(MAX_SIZE)
                .stream()
                .map(Number::new)
                .collect(Collectors.toList());

        return new Numbers(numberList);
    }

    public Numbers(List<Number> numberList) {
        Collections.sort(numberList);
        numbers.addAll(numberList);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

}
