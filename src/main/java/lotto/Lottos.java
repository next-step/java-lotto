package lotto;

import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    public long numberOfFirstDivision(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Division.FIRST == lotto.checkDivision(winners))
            .count();
    }

    public long numberOfSecondDivision(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Division.SECOND == lotto.checkDivision(winners))
            .count();
    }

    public long numberOfThirdDivision(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Division.THIRD == lotto.checkDivision(winners))
            .count();
    }

    public long numberOfFourthDivision(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Division.FOURTH == lotto.checkDivision(winners))
            .count();
    }
}
