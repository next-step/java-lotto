package lotto;

public class LottoPurchase {
    private static final int LOTTO_PRICE = 1000;

    public int buyLotto(int money) {
        return money / LOTTO_PRICE;
    }

}
