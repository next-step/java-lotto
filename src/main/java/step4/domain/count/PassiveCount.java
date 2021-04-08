package step4.domain.count;

import step4.exception.InputNegativeAmountException;

public final class PassiveCount {

    public static final int ZERO = 0;

    private final int count;

    private PassiveCount(int count) {
        validateNegative(count);
        this.count = count;
    }

    public static final PassiveCount valueOf(int count) {
        return new PassiveCount(count);
    }

    private final void validateNegative(int count) {
        if (count < ZERO) {
            throw new InputNegativeAmountException();
        }
    }

    public final int getCount() {
        return count;
    }
}
