package lotto.model;

public class Cashier {
    private static final int LOTTO_PRICE = 1_000;

    private final int price;
    private final int lottoQuantity;

    public Cashier(int price) {
        this.price = price;
        lottoQuantity = price / LOTTO_PRICE;
    }

    public int getPrice() {
        return price;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
