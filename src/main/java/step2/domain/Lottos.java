package step2.domain;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningStatistics winningStatistics(Lotto prizeLotto) {
        return new WinningStatistics(this.lottos.stream().collect(
                groupingBy(
                    lotto -> lotto.countOfWinningNumber(prizeLotto),
                    collectingAndThen(toList(), Lottos::new)
                )
            ));
    }

    public List<Lotto> lottos() {
        return this.lottos;
    }

    public int size() {
        return this.lottos.size();
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

}
