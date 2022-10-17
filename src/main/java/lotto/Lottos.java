package lotto;

import java.util.List;
import java.util.Objects;

import lotto.model.BonusNumber;
import lotto.model.WinningNumber;

public class Lottos {
    private final List<Integer> numbers;

    public Lottos(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoMatchResult match(WinningNumber winningNumber, BonusNumber bonusNumber) {
        long matched = numbers.stream()
                              .filter(winningNumber::exists)
                              .count();

        boolean bonusNumberMatched = numbers.stream()
                                            .anyMatch(bonusNumber::match);

        return LottoMatchResult.of((int) matched, bonusNumberMatched);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lottos)) {
            return false;
        }
        Lottos that = (Lottos) o;
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
