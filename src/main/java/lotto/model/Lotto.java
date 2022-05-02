package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    private final List<Number> numbers;

    public Lotto() {
        this(new ArrayList<>());
    }

    private Lotto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto draw() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> shuffleResult = LOTTO_NUMBERS.subList(0, 6);
        Collections.sort(shuffleResult);

        List<Number> numbers = shuffleResult
                .stream()
                .map(Number::new)
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    public static Lotto draw(List<Number> numbers) {
        return new Lotto(numbers);
    }

    public Number contains(Collection<Number> numbers) {
        long count = numbers
                .stream()
                .filter(this::contains)
                .count();

        return new Number(count);
    }

    public Number contains(Lotto lotto) {
        return this.contains(lotto.numbers);
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }

    public List<Number> getNumbers() {
        return this.numbers;
    }
}
