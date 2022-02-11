package lotto.domain.lotto;

public class Amount {

    private static final String INVALID_AMOUNT = "구매금액은 음수이거나 1000원 이외의 단위가 될 수 없습니댜.";
    private static final int PRICE_PER_ONE_TICKET = 1000;
    private static final int VALIDATION_BASE_UNIT = 0;

    private final int amount;

    public Amount(final int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public int value() {
        return amount;
    }

    private void validateAmount(final int amount) {
        if (amount < VALIDATION_BASE_UNIT || amount % PRICE_PER_ONE_TICKET > VALIDATION_BASE_UNIT) {
            throw new IllegalArgumentException(INVALID_AMOUNT);
        }
    }
}
