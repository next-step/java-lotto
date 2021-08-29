package lotto.domain;

import java.util.List;

public class LottoEvent {
    private PurchaseAmount purchaseAmount;
    private PurchaseLottoList purchaseLottoList;
    private Lotto winningNumber;
    private LottoResults lottoResults;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        purchaseLottoList = new PurchaseLottoList(this.purchaseAmount.getLottoCount());
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
        setLottoResults();
    }

    private void setLottoResults() {
        lottoResults = new LottoResults(purchaseLottoList, winningNumber);
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottoList.getPurchaseLottoList();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}
