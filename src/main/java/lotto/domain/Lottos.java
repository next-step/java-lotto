package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResults matchWinLotto(Lotto winLotto) {
        LottoResults results = new LottoResults();
        for (Lotto lotto : lottos) {
            results.addRank(lotto.matchWinLotto(winLotto));
        }
        return results;
    }
}
