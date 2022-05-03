package lotto.domain;

public class Amount {
    static final long MIN = 0;

    private final long value;

    public Amount(String value) {
        this(Integer.parseInt(value));
    }

    public Amount(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (isSmallerThanMin(value)) {
            throw new IllegalArgumentException(String.format("amount(%s)는 %s 이하 일 수 없습니다.", value, MIN));
        }
    }

    private boolean isSmallerThanMin(long value) {
        return value < MIN;
    }

    public long getValue() {
        return value;
    }
}
