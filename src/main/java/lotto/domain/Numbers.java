package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private static final int ZERO = 0;
    private static final int SIZE = 6;
    private static final List<Integer> baseNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private final List<Integer> numbers;

    public Numbers() {
        Collections.shuffle(baseNumbers);
        this.numbers = baseNumbers.subList(ZERO, SIZE).stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
