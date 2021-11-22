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
    private static final int size = 6;
    private static final Random r = new Random();

    private final List<PositiveNumber> numbers;

    public Lotto(List<PositiveNumber> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        this.numbers = createByStrings(numbers);
    }

    public List<PositiveNumber> getNumbers() {
        return numbers;
    }

    public static Lotto createByAuto() {
        List<PositiveNumber> numbers = IntStream
            .range(0, size)
            .mapToObj(o -> new PositiveNumber(r.nextInt(seed)))
            .collect(Collectors.toList());

        Collections.sort(numbers, Comparator.comparing(PositiveNumber::getNumber));
        return new Lotto(numbers);
    }

    private List<PositiveNumber> createByStrings(String numbers) {
        return Arrays.asList(numbers.split(","))
            .stream()
            .map(String::trim)
            .map(PositiveNumber::new)
            .collect(Collectors.toList());
    }
}
