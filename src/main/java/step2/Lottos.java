package step2;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void calculateTotalRank(Lotto winnerLotto) {
        for (Lotto lotto : lottos) {
            lotto.compareToMatchNumberCount(winnerLotto);
        }
    }
}
