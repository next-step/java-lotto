package lotto.model;

import lotto.util.Roulette;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int MAX_SIZE = 6;
    private final Set<Number> numbers;

    public Lotto() {
        this.numbers = new HashSet<>(MAX_SIZE);
    }

    public void draw() {
        Set<Number> numbers = IntStream.range(0, MAX_SIZE)
                .mapToObj(index -> Roulette.spin())
                .collect(Collectors.toSet());
        this.checkSize(numbers);
        this.draw(numbers);
    }

    public void draw(Collection<Number> numbers) {
        this.checkSizeException(numbers);
        this.numbers.addAll(numbers);
    }

    private void checkSize(Collection<Number> numbers) {
        if (numbers.size() < MAX_SIZE) {
            IntStream.range(numbers.size(), MAX_SIZE)
                    .forEach(index -> numbers.add(Roulette.spin()));
        }
    }

    private void checkSizeException(Collection<Number> numbers) {
        if (numbers.size() < MAX_SIZE) {
            throw new IllegalArgumentException("선택된 로또 번호 개수가 부족합니다.");
        }
    }

    public Set<Number> getNumbers() {
        return this.numbers;
    }
}
