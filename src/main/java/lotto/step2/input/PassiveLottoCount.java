package lotto.step2.input;

public class PassiveLottoCount {
    private final int value;

    public PassiveLottoCount(final int passiveLottoCount) {
        if (passiveLottoCount <= 0) {
            throw new IllegalArgumentException("passiveLottoCount must be greater than 0");
        }

        this.value = passiveLottoCount;
    }

    public int getValue() {
        return value;
    }
}
