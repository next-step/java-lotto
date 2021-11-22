package lotto.domain;

import calculator.PositiveNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class Lotto {
    private static final int seed = 46;
    private static final int size = 5;
    private static final Random r = new Random();

    private final List<PositiveNumber> numbers;

    public Lotto(List<PositiveNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createByAuto() {
        List<PositiveNumber> numbers = IntStream
            .range(0, size)
            .mapToObj(o -> new PositiveNumber(r.nextInt(seed)))
            .collect(Collectors.toList());

        Collections.sort(numbers, Comparator.comparing(PositiveNumber::getNumber));
        return new Lotto(numbers);
    }

    public List<PositiveNumber> getNumbers() {
        return numbers;
    }
}
