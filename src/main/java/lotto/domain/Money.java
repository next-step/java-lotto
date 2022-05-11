package lotto.domain;

import jdk.swing.interop.SwingInterOpUtils;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String BUY_PRICE_VALID_ERROR_MESSAGE = "1,000원 단위로만 구매 가능합니다.";
    private static final String WRONG_NUMBER_EXCEPTION = "숫자형식이 아닙니다.";
    private static final String EXCEED_QUANTITY_MESSAGE = "수량을 초과하였습니다. ";

    private final int buyPrice;
    private final int maxPurchasableQuantity;

    private int purchasedQuantity;

    public Money(String buyPrice, int purchasedQuantity) {
        this.buyPrice = parseInt(buyPrice);
        this.maxPurchasableQuantity = this.buyPrice / LOTTO_PRICE;
        this.purchasedQuantity = purchasedQuantity;
        validate();
    }

    private int parseInt(String buyPrice) {
        try {
            return Integer.parseInt(buyPrice);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_NUMBER_EXCEPTION);
        }
    }

    private void validate() {
        if (this.buyPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(BUY_PRICE_VALID_ERROR_MESSAGE);
        }
        if (maxPurchasableQuantity < purchasedQuantity) {
            throw new IllegalArgumentException(EXCEED_QUANTITY_MESSAGE + this);
        }
    }

    public void addQuantity() {
        if (!isPurchasable()) {
            throw new IllegalArgumentException("구매가능수량을 초과하였습니다.");
        }
        purchasedQuantity++;
    }

    public boolean isPurchasable() {
        return maxPurchasableQuantity > purchasedQuantity;
    }

    public int getMaxPurchasableQuantity() {
        return maxPurchasableQuantity;
    }

    public double getReturnRate(int winningMoney) {
        return (double) winningMoney / this.buyPrice;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "buyPrice=" + buyPrice +
                ", purchasedQuantity=" + purchasedQuantity +
                ", maxPurchasableQuantity=" + maxPurchasableQuantity +
                '}';
    }

}
