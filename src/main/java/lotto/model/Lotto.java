package lotto.model;

import lotto.common.Delimiter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    private List<Number> numbers;

    public Lotto draw() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> shuffleResult = LOTTO_NUMBERS.subList(0, 6);
        Collections.sort(shuffleResult);

        this.numbers = shuffleResult
                .stream()
                .map(Number::new)
                .collect(Collectors.toList());

        return this;
    }

    public Lotto draw(List<Number> numbers) {
        this.numbers = numbers;

        return this;
    }

    public int contains(Collection<Number> numbers) {
        return (int) numbers.stream()
                .filter(this::contains)
                .count();
    }

    public int contains(Lotto lotto) {
        return this.contains(lotto.numbers);
    }

    public boolean contains(Number number) {
        return this.numbers.contains(number);
    }

    public List<Number> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        String numbers = this.numbers
                .stream()
                .map(Number::toString)
                .collect(Collectors.joining(Delimiter.COMMA.symbol));

        return "[" + numbers + "]";
    }
}
