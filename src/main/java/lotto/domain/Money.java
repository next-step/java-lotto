package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String BUY_PRICE_VALID_ERROR_MESSAGE = "1,000원 단위로만 구매 가능합니다.";
    private static final String WRONG_NUMBER_EXCEPTION = "숫자형식이 아닙니다.";

    private final int buyPrice;
    private Quantity quantity;

    public Money(String buyPrice) {
        this(buyPrice, 0);
    }

    public Money(String buyPrice, int purchasedQuantity) {
        this.buyPrice = parseInt(buyPrice);
        this.quantity = new Quantity(this.buyPrice / LOTTO_PRICE, purchasedQuantity);
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
    }

    public void addQuantity() {
        this.quantity = quantity.increase();
    }

    public boolean isPurchasable() {
        return quantity.isPurchasable();
    }

    public int getMaxPurchasableQuantity() {
        return quantity.getMaxPurchasableQuantity();
    }

    public double calculateReturnRate(int winningMoney) {
        return (double) winningMoney / this.buyPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return buyPrice == money.buyPrice && Objects.equals(quantity, money.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyPrice, quantity);
    }

    @Override
    public String toString() {
        return "Money{" +
                "buyPrice=" + buyPrice +
                ", quantity=" + quantity +
                '}';
    }
}
