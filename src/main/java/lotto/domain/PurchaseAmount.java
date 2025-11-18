package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_AMOUNT = 0;

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount <= MIN_AMOUNT) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public int getAmount() {
        return amount;
    }

}
