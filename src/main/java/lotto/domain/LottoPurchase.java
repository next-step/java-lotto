package lotto.domain;


public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;
    public final int LOTTO_AMOUNT;
    public int LOTTO_COUNT;

    public LottoPurchase(int money) {
        this.LOTTO_AMOUNT = money;
    }

    public int buyLotto() {
        this.LOTTO_COUNT = LOTTO_AMOUNT / LOTTO_PRICE;
        return LOTTO_COUNT;
    }

}
