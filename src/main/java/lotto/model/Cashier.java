package lotto.model;

public class Cashier {
    private int price;

    public Cashier(int price) {
        this.price = price;
    }

    public int calculateLottoQuantity() {
        return price / 1_000;
    }

    public int calculateAutoLottoQuantity(int manualQuantity) {
        return calculateLottoQuantity() - manualQuantity;
    }

    public int getPrice() {
        return price;
    }
}
