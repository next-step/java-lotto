package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int countMatch(final List<LottoNumber> winningNumbers) {
        int countMatch = 0;
        for (LottoNumber number : numbers) {
            countMatch = number.countMatch(winningNumbers, countMatch);
        }
        return countMatch;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
