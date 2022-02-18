package lotto.domain;

public class LottoPrice {

    private static final int ERROR_WRONG_LOTTO_PRICE = 0;
    private static final int LOTTO_PRICE = 1000;

    private final int price;

    public LottoPrice(int price) {
        this.price = price;
    }

    public int getLottoCount() {
        return price / LOTTO_PRICE;
    }

    public boolean isErrorOrNot() {
        return price % LOTTO_PRICE != ERROR_WRONG_LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }
}
