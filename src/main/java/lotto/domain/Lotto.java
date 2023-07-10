package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;
    private static final List<Integer> values = IntStream.rangeClosed(LOTTO_START, LOTTO_END)
        .boxed()
        .collect(Collectors.toList());

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static Lotto createLotto() {
        Collections.shuffle(values);
        return new Lotto(values.subList(0, LOTTO_SIZE));
    }
}
