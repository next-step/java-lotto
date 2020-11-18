package step02.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    public int matchCount(Lotto winningNumbers) {
        return lotto.stream().reduce(0, (total, number) -> {
            if (winningNumbers.lotto.contains(number)) {
                total += 1;
            }
            return total;
        });
    }

    public List<Integer> print() {
        return lotto;
    }
}
