package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int findRank(Lotto win, Rank rank) {
        return (int) lottos.stream()
                .filter(lotto->Rank.findRank(lotto.countSameNumber(win)) == rank)
                .count();
    }

    public List<Lotto> getValue() {
        return lottos;
    }

}
