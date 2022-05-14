package lotto.domain;

import lotto.domain.constant.Rank;
import java.util.List;

public class LottoGame {

    private final PurchaseAmount purchaseAmount;
    private final Lottos lottos;

    public LottoGame(Money money) {
        this.purchaseAmount = Store.buyLotto(money);
        this.lottos = new Lottos(purchaseAmount);
    }

    public int getLottoAmount() {
        return lottos.getLottoAmount();
    }

    public void confirmLottos(LottoNumbers winningLottoNumbers) {
        lottos.confirmAll(winningLottoNumbers);
    }

    public List<LottoNumbers> getLottoNumbers() {
        return this.lottos.getLottoNumbers();
    }

    public int isSameRank(Lottos lottos, Rank rank) {
        return lottos.countMatchRank(rank);
    }
}
