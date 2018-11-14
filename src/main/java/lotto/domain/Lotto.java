package lotto.domain;

import lotto.utils.LottoNumberGenerator;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    private Lotto() {
        this.numbers = LottoNumberGenerator.generate();
    }

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create() {
        return new Lotto();
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public boolean hasMatches(List<Integer> target, int count) {
        return count == this.numberOfMatches(target);
    }

    public int numberOfMatches(List<Integer> target) {
        return Math.toIntExact(target.stream()
                .filter(this::contains)
                .count());
    }

    private boolean contains(int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
