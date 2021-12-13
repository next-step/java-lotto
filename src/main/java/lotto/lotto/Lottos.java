package lotto.lotto;

import lotto.result.MatchedNumbers;

import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public long match(LottoNumbers winningNumbers, MatchedNumbers matchedNumbers) {
        return lottos.stream()
                .filter(lotto -> lotto.match(
                        winningNumbers,
                        count -> count == matchedNumbers.value())
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
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
