package lotto.domain;

import lotto.domain.constant.Rank;

import java.util.List;

public class LottoGame {

    private final int LOTTO_PRICE = 1000;

    private final PurchaseAmount purchaseAmount;
    private final PurchaseLottoCount purchaseLottoCount;
    private final Lottos lottos;

    public LottoGame(PurchaseAmount purchaseAmount) {
        this.purchaseLottoCount = new PurchaseLottoCount(purchaseAmount, LOTTO_PRICE);
        this.purchaseAmount = purchaseAmount;
        this.lottos = new Lottos(purchaseLottoCount);
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

    public int matchRankCount(Rank rank) {
        return lottos.countMatchRank(rank);
    }

    public double calculateBenefitRate() {
        return (double) lottos.getTotalPrizeMoney() / (double) purchaseAmount.getPurchaseAmount();
    }
}
