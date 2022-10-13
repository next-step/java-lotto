package lotto;

import java.util.List;
import java.util.Objects;

import lotto.model.WinningNumber;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoMatchResult match(WinningNumber winningNumber) {
        int matched = 0;

        for (Integer number : numbers) {
            if (winningNumber.exists(number)) {
                matched++;
            }
        }

        return new LottoMatchResult(matched);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
