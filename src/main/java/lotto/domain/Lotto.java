package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateIfNotNull();
    }

    private void validateIfNotNull() {
        if (this.numbers == null) throw new IllegalArgumentException();
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    public boolean isBonusContains(Integer bonusNumber) {
        return Match.getCount(numbers, bonusNumber);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
