package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(final List<Lotto> manualLottos, final List<Lotto> autoLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(autoLottos);
        return new Lottos(lottos);
    }

    public int getRankCount(final WinningLotto winningLotto, final Rank criteriaRank) {
        return (int) lottos.stream()
                .map(lotto -> winningLotto.rank(lotto))
                .filter(rank -> rank.equals(criteriaRank))
                .count();
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
