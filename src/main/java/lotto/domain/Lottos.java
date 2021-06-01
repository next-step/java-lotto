package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void updateLottoResult(Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            LottoPrize.findByMatchCount(matchCount).updateWinningResult(matchCount);
        }
    }

}
