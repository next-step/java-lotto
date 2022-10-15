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
        int matched = 0;

        for (Integer number : numbers) {
            if (winningNumber.exists(number)) {
                matched++;
            }
        }

        return LottoMatchResult.of(matched);
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
