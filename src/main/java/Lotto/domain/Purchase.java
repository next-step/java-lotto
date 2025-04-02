package Lotto.domain;

import Lotto.utils.ValidationUtils;

public class Purchase {
    public static final int UNIT = 1000;
    private int price = 0;
    private int quantity;

    public Purchase(int price) {
        this.price = price;
        this.quantity = purchaseLotto(price);
    }

    private int purchaseLotto(int price) {
        return price / UNIT;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
