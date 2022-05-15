package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final Number START_NUMBER = Number.of(1);
    private static final Number END_NUMBER = Number.of(46);
    private static final Number START_INDEX = Number.of();
    private static final Number END_INDEX = Number.of(6);
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
                .subList(START_INDEX.intValue(), END_INDEX.intValue())
                .stream()
                .sorted()
                .map(Number::of)
                .collect(Collectors.toList());

        return this;
    }

    public static Lotto auto() {
        List<Integer> numbers = IntStream
                .range(START_NUMBER.intValue(), END_NUMBER.intValue())
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

    public Number match(List<Number> target) {
        long correctCount = this.lotto
                .stream()
                .filter(target::contains)
                .count();

        return Number.of(correctCount);
    }

    public static Rank getRank(Lotto criteria, Lotto target) {
        return Rank.valueOf(criteria.match(target.lotto));
    }

    public List<Number> getLotto() {
        return this.lotto;
    }

    @Override
    public String toString() {
        return this.lotto.toString();
    }
}
