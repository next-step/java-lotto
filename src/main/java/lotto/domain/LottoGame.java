package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private Lottos lottos;
    public LottoGame(final int purchaseAmount) {
        this.lottos = new Lottos(purchaseAmount);
    }

    public int purchaseCount() {
        return lottos.purchaseCount();
    }
}
