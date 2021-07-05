package lotto.model;

public class Cashier {
    private static final int LOTTO_PRICE = 1_000;
    private int price;

    public Cashier(int price) {
        this.price = price;
    }

    public int calculateLottoQuantity() {
        return price / LOTTO_PRICE;
    }

    public int calculateAutoLottoQuantity(int manualQuantity) {
        return calculateLottoQuantity() - manualQuantity;
    }

    public int getPrice() {
        return price;
    }
}
