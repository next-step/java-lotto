package lotto.domain;

import lotto.domain.exception.NegativePriceException;
import lotto.domain.exception.NullPurchasePriceException;

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

    public static PurchasePrice subtractPrice(PurchasePrice purchasePrice1, PurchasePrice purchasePrice2) {
        if (purchasePrice1 == null || purchasePrice2 == null) {
            throw new NullPurchasePriceException();
        }
        return new PurchasePrice(purchasePrice1.getPrice() - purchasePrice2.getPrice());
    }
}
