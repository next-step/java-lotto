package Lotto.model;

import static Lotto.model.LottoService.SALES_PRICE;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < SALES_PRICE) {
            throw new IllegalArgumentException("The minimum of purchase price is 1,000 won.");
        }

        if (purchaseAmount % SALES_PRICE != 0) {
            throw new IllegalArgumentException("The purchase price is in units of 1,000 won.");
        }
        this.purchaseAmount = purchaseAmount;
    }

    public int value(){
        return purchaseAmount;
    }
}
