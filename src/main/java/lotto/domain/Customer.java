package lotto.domain;

import java.util.List;

public class Customer {
    private int purchaseAmount;
    private List<Lotto> lottoList;

    public Customer() {
    }

    public Customer(int purchaseAmount, List<Lotto> lottoList) {
        this.purchaseAmount = purchaseAmount;
        this.lottoList = lottoList;
    }

    public void purchaseLotto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoList = LottoShop.sellLotto(purchaseAmount);
    }

    public void purchaseLotto(int purchaseAmount, List<Lotto> manualLottoList) {
        this.purchaseAmount = purchaseAmount;
        this.lottoList = LottoShop.sellLotto(purchaseAmount, manualLottoList);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
