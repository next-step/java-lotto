package lotto.domain;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public LottoMoney(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int calculateLottoAmount() {
        return amount / LOTTO_PRICE;
    }
}
