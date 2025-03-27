package lotto.domain;

import lotto.domain.generator.LottoGenerator;

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
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("구입금액은 0 이하일 수 없습니다. 입력한 구입금액: " + purchaseAmount);
        }

        this.purchaseAmount = purchaseAmount;
        this.lottoList = LottoGenerator.generateLottoListByAmount(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
