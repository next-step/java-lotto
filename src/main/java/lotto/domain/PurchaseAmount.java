package lotto.domain;

public class PurchaseAmount {

    private static final int PRICE_PER_PIECE = 1000;
    private static final String INVALID_AMOUNT_EXCEPTION_MESSAGE_FORMAT = "구매 금액은 1000으로 나누어 떨어지는 양의 정수이어야합니다. amount: %s";

    private final int amount;

    private PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (isNegative(amount) || isNotDivided(amount)) {
            throw new IllegalArgumentException(String.format(INVALID_AMOUNT_EXCEPTION_MESSAGE_FORMAT, amount));
        }
    }

    private boolean isNotDivided(int amount) {
        return amount % PRICE_PER_PIECE > 0;
    }

    private boolean isNegative(int amount) {
        return amount < 0;
    }

    public static PurchaseAmount of(int amount) {
        return new PurchaseAmount(amount);
    }

    public int getPurchaseQuantity() {
        return amount / PRICE_PER_PIECE;
    }
}
