package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public int countWinningNumbers(final InputNumber inputNumber) {
        return inputNumber.countWinningNumbers(numbers);
    }

    public boolean containsBonusNumber(final InputNumber inputNumber) {
        boolean isMatch = false;
        for (Number number : numbers) {
            isMatch = inputNumber.existBonusNumber(number);
        }
        return isMatch;
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
