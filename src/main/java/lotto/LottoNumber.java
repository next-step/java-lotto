package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoMatchResult match(List<Integer> winningNumbers) {
        int matched = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
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
