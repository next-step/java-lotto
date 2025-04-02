package lotto.domain;

import java.util.Map;

public class Customer {
    private int purchaseAmount;
    private Lottos lottos;

    public Customer() {
    }

    public Customer(int purchaseAmount, Lottos lottos) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
    }

    public void purchaseLotto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = LottoShop.sellAutoLottos(purchaseAmount);
    }

    public void purchaseLotto(int purchaseAmount, Lottos manualLottoList) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = LottoShop.sellLottosWithManualAndAuto(purchaseAmount, manualLottoList);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Map<Rank, Integer> determineLottosResult(WinningLotto winningLotto) {
        return lottos.analyzeLottoStatistics(winningLotto);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
