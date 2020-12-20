package step2.domain;

public class LottoRequest {
    private int purchaseMoney;

    public LottoRequest(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
