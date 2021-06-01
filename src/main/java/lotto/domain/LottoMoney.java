package lotto.domain;

public class LottoMoney {

    static final int LOTTO_PRICE = 1000;
    int value;

    public LottoMoney(int purchaseMoney) {
        validateLottoMoney(purchaseMoney);
        this.value = purchaseMoney - (purchaseMoney % LOTTO_PRICE);
    }

    private void validateLottoMoney(int purchaseMoney) {
        if (LOTTO_PRICE > purchaseMoney) {
            throw new IllegalArgumentException("로또 최소 구매 비용은 " + LOTTO_PRICE + "원 입니다.");
        }
    }

    public int getValue() {
        return value;
    }

}
