package lotto.domain;

import java.util.Objects;

public class PurchaseQuantity {

    private static final Money PRICE_PER_PIECE = Money.of(1000);
    private static final String INVALID_MONEY_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 금액입니다. Money: %s";
    private static final String NEGATIVE_QUANTITY_EXCEPTION_MESSAGE_FORMAT = "구매 수량이 0보다 작습니다. quantity: %s";
    private static final int MINIMUM_QUANTITY = 0;

    private final long quantity;

    private PurchaseQuantity(long quantity) {
        validateMinimumQuantity(quantity);
        this.quantity = quantity;
    }

    private void validateMinimumQuantity(long quantity) {
        if (quantity < MINIMUM_QUANTITY) {
            throw new IllegalArgumentException(String.format(NEGATIVE_QUANTITY_EXCEPTION_MESSAGE_FORMAT, quantity));
        }
    }

    public static PurchaseQuantity of(long quantity) {
        return new PurchaseQuantity(quantity);
    }

    public static PurchaseQuantity withAutomatic(Money money, PurchaseQuantity manual) {
        validateDivisibleByPricePerPiece(money);
        return new PurchaseQuantity((long) money.divide(PRICE_PER_PIECE) - Objects.requireNonNull(manual).quantity);
    }

    private static void validateDivisibleByPricePerPiece(Money money) {
        if (money == null || !money.isDivisibleBy(PRICE_PER_PIECE)) {
            throw new IllegalArgumentException(String.format(INVALID_MONEY_EXCEPTION_MESSAGE_FORMAT, money));
        }
    }

    public long getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseQuantity)) return false;
        PurchaseQuantity that = (PurchaseQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return (int) (quantity ^ (quantity >>> 32));
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }
}
