package lotto.domain;

import lotto.domain.exception.NegativePriceException;

public class PurchasePrice {

    private final int price;

    public PurchasePrice(int price) {
        if (price < 0) {
            throw new NegativePriceException();
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
