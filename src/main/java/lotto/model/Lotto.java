package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 46;
    private List<Number> lotto;

    private Lotto() {
        this.lotto = new ArrayList<>();
    }

    private Lotto(List<Number> lotto) {
        this.lotto = lotto;
    }

    private Lotto shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);

        this.lotto = numbers
                .subList(0, 6)
                .stream()
                .map(Number::of)
                .collect(Collectors.toList());

        return this;
    }

    public static Lotto auto() {
        List<Integer> numbers = IntStream
                .range(START_NUMBER, END_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        return new Lotto()
                .shuffle(numbers);
    }

    public static Lotto manual(List<Integer> numbers) {
        List<Number> lotto = numbers
                .stream()
                .sorted()
                .map(Number::of)
                .collect(Collectors.toList());

        return new Lotto(lotto);
    }

    public static Number match(Lotto criteria, Lotto target) {
        long correctCount = criteria.lotto
                .stream()
                .filter(number -> target.lotto.contains(number))
                .count();

        return Number.of(correctCount);
    }

    public List<Number> getLotto() {
        return this.lotto;
    }
}
