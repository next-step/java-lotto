package lotto.domain;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Ranking> matchesWinningLotto(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.findRankingByLotto(winningLotto))
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(this.lottos, lottos.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
