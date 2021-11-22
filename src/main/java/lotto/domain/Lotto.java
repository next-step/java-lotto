package lotto.domain;

import calculator.PositiveNumber;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Lotto {
    private static final int seed = 46;
    private static final int size = 6;
    private static final Random r = ThreadLocalRandom.current();

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
        List<PositiveNumber> numbers = r.ints(1, seed)
            .distinct()
            .limit(size)
            .mapToObj(PositiveNumber::new)
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
