package lotto.domain;

import java.util.List;

public class LottoEvent {
    private PurchaseAmount purchaseAmount;
    private PurchaseLottos purchaseLottos;
    private Lotto winningNumber;
    private LottoResults lottoResults;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        purchaseLottos = new PurchaseLottos(this.purchaseAmount.getLottoCount());
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
        setLottoResults();
    }

    private void setLottoResults() {
        lottoResults = new LottoResults(purchaseLottos, winningNumber);
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottos.getPurchaseLottoList();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}
