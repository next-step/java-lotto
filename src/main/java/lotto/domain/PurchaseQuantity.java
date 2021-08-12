package lotto.domain;

public class PurchaseQuantity {

    private static final Money PRICE_PER_PIECE = Money.of(1000);
    private static final String INVALID_MONEY_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 금액입니다. Money: %s";

    private final long quantity;

    private PurchaseQuantity(long quantity) {
        this.quantity = quantity;
    }

    public static PurchaseQuantity of(Money money) {
        validateDivisibleByPricePerPiece(money);
        return new PurchaseQuantity((long) money.divide(PRICE_PER_PIECE));
    }

    private static void validateDivisibleByPricePerPiece(Money money) {
        if (money == null || !money.isDivisibleBy(PRICE_PER_PIECE)) {
            throw new IllegalArgumentException(String.format(INVALID_MONEY_EXCEPTION_MESSAGE_FORMAT, money));
        }
    }

    public long getQuantity() {
        return quantity;
    }

    public Money getPurchaseAmount() {
        return PRICE_PER_PIECE.multiply(quantity);
    }
}
