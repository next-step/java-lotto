package lotto.domain;

import java.util.ArrayList;
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

    public Lottos merge(List<Lotto> manualLottos) {
        List<Lotto> newLottos = new ArrayList<>(this.lottos);
        newLottos.addAll(manualLottos);
        return new Lottos(newLottos);
    }

    public LottoResult findResult(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            result.addMatch(winningLotto.match(lotto));
        }
        return result;
    }

    public int size() {
        return lottos.size();
    }
}
