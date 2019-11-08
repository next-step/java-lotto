package lotto.domain2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return this.lottos.size();
    }

    WinningLottos checkWinning(final List<LottoNumber> winningLotto) {
        final WinningLottos winningLottos = new WinningLottos();

        for (Lotto lotto : lottos) {
            final int countOfMatch = lotto.getCountOfMatchWith(new Lotto(winningLotto));
            final Rank rank = Rank.findByCountOfMatch(countOfMatch);
            winningLottos.addOnlyWinning(lotto, rank);
        }

        return winningLottos;
    }

    List<Lotto> findAllLottos() {
        return Collections.unmodifiableList(lottos);
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
