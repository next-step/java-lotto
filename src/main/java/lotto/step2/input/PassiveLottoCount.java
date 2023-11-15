package lotto.step2.input;

public class PassiveLottoCount {
    public static final int MIN_VALUE = 1;
    private final int value;

    public PassiveLottoCount(final int passiveLottoCount, final int maxCount) {
        if (isOutOfRange(passiveLottoCount, maxCount)) {
            throw new IllegalArgumentException("passiveLottoCount must be between " + MIN_VALUE + " and " + maxCount);
        }

        this.value = passiveLottoCount;
    }

    private boolean isOutOfRange(final int passiveLottoCount, final int maxCount) {
        return passiveLottoCount < MIN_VALUE || maxCount < passiveLottoCount;
    }

    public int getValue() {
        return value;
    }
}
