package lotto.model;

public class LottoPrice {
    private static int price;

    public LottoPrice(int price) {
        this.price = price;
    }

    public static int getPrice() {
        return price;
    }

    public int calculateLottoQuantity() {
        return price / 1_000;
    }
}
