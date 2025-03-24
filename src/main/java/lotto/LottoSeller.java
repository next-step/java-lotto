package lotto;

public class LottoSeller {
    private static final int PRICE = 1000;

    public int getPurchasableLottoCount(Money money) {
        return money.getAmount() / PRICE;
    }
}
