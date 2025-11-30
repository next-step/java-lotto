package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count) {
        this(LottoFactory.generateLottos(count));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> values() {
        return lottos;
    }

    public LottoResult findResult(Lotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            int match = lotto.match(winningLotto);
            result.addMatch(match);
        }
        return result;
    }
}
