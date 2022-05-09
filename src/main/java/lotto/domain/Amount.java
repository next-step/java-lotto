package lotto.domain;

public class Amount {
    static final long MIN = 0;

    private final long amount;

    public Amount() {
        this(MIN);
    }

    public Amount(String amount) {
        this(Integer.parseInt(amount));
    }

    public Amount(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long value) {
        if (isSmallerThanMin(value)) {
            throw new IllegalArgumentException(String.format("amount(%s)는 %s 미만 일 수 없습니다.", value, MIN));
        }
    }

    private boolean isSmallerThanMin(long value) {
        return value < MIN;
    }

    public long getAmount() {
        return amount;
    }

    public Amount save(Amount amount) {
        return new Amount(this.amount + amount.amount);
    }

    public Amount spend(Amount amount) {
        return new Amount(this.amount - amount.amount);
    }
}
