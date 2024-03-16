package lotto;

public class Seller {
    private final static int LOTTO_PRICE = 1000;

    public Integer getBuyLottoNumber(final int amount) {
        return amount / LOTTO_PRICE;
    }
}
