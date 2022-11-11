package step2.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new LottoNumber().getLottoNumbers();
    }

    public int countMatchNumber(WinningNumbers winningNumbers) {
        return (int) winningNumbers.getWinningNumbers()
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean matchBonusNumber(WinningNumbers winningNumbers) {
        return numbers.contains(winningNumbers.getBonusNumber());
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}