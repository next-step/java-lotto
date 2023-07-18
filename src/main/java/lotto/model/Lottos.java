package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Lottos {

    private final List<Lotto> lottos;

    protected Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public RankResultsDto matchWinningNumbers(final WinningNumbers winningNumbers) {
        return new RankResultsDto(lottos.stream()
                .map(winningNumbers::checkRank)
                .collect(Collectors.toUnmodifiableList()));
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(this.lottos);
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
