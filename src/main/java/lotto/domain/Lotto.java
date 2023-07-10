package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> numbers;
    private static final List<Integer> values = IntStream.rangeClosed(1, 45)
        .boxed()
        .collect(Collectors.toList());

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static Lotto createLotto() {
        Collections.shuffle(values);
        return new Lotto(values.subList(0, 6));
    }
}
