package lotto.domain;

import lotto.result.LottoMatchResult;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addLottos(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public LottoMatchResult match(WinningLotto winningLotto) {
        LottoMatchResult result = new LottoMatchResult();
        for (Lotto lotto : lottos) {
            result.updateRank(winningLotto.match(lotto));
        }
        return result;
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
