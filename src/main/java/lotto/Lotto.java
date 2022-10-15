package lotto;

import java.util.List;
import java.util.Objects;

import lotto.model.WinningNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoMatchResult match(WinningNumber winningNumber) {
        long matched = numbers.stream()
                              .filter(winningNumber::exists)
                              .count();

        return LottoMatchResult.of((int) matched);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        Lotto that = (Lotto) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
