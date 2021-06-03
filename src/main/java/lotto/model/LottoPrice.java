package lotto.model;

public class LottoPrice {
    private int price;

    public LottoPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int calculateLottoQuantity() {
        return price / 1_000;
    }
}
