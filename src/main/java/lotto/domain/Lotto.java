package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private Numbers numbers;
    private int price;

    public Lotto() {
        this.numbers = new Numbers();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public int matchCount(List<Integer> winningNumbers) {
        return numbers.matchCount(winningNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "numbers=" + numbers + '}';
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
