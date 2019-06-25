package lotto.model.generator;

import lotto.model.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NumberGenerator {

    private static final List<Number> numbers;

    static {
        numbers = IntStream.rangeClosed(Number.MIN, Number.MAX)
                .mapToObj(Number::of)
                .collect(toList());
    }

    public List<Number> peek(int count) {
        List<Number> numbers = IntStream.range(0, count)
                .mapToObj(this::getNumber)
                .collect(toList());
        return new ArrayList<>(numbers);
    }

    private Number getNumber(int num) {
        return numbers.get(num);
    }

    static void shuffle() {
        Collections.shuffle(numbers);
    }
}
