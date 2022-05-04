package lotto.domain;

public class Amount {
    static final long MIN = 0;

    private final long amount;

    public Amount(String amount) {
        this(Integer.parseInt(amount));
    }

    public Amount(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long value) {
        if (isSmallerThanMin(value)) {
            throw new IllegalArgumentException(String.format("amount(%s)는 %s 이하 일 수 없습니다.", value, MIN));
        }
    }

    private boolean isSmallerThanMin(long value) {
        return value < MIN;
    }

    public long getAmount() {
        return amount;
    }
}
