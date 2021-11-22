package lotto.domain;

import calculator.PositiveNumber;

import java.util.*;

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
        List<PositiveNumber> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(new PositiveNumber(r.nextInt(seed)));
        }

        Collections.sort(numbers, Comparator.comparing(PositiveNumber::getNumber));
        return new Lotto(numbers);
    }

    public List<PositiveNumber> getNumbers() {
        return numbers;
    }
}
