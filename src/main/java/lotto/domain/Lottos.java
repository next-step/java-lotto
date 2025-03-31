package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount, LottoNumberGenerator generator) {
        lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(generator));
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public int count() {
        return lottos.size();
    }

    public WinningResult countMatchResults(Lotto winningLotto) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            countIfWinningLotto(winningLotto, lotto, winningResult);
        }
        return winningResult;
    }

    private static void countIfWinningLotto(Lotto winningLotto, Lotto lotto,
        WinningResult winningResult) {
        if (lotto.isWinningLotto(winningLotto)) {
            winningResult.add(lotto.countMatchWith(winningLotto));
        }
    }
}
