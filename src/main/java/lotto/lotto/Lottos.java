package lotto.lotto;

import lotto.result.MatchedNumbersCount;

import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public long match(LottoNumbers winningNumbers, MatchedNumbersCount matchedNumbersCount) {
        return values.stream()
                .filter(lotto -> lotto.match(
                        winningNumbers,
                        count -> count == matchedNumbersCount.value())
                )
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(values, lottos1.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
