package lotto.game;

import lotto.exception.LottoIllegalArgumentException;

public class LottoCount {
    private final int value;

    public LottoCount(int value) {
        if (value < 0) {
            throw LottoIllegalArgumentException.NEGATIVE_COUNT;
        }
        this.value = value;
    }

    public boolean isGreaterThan(int count) {
        return value > count;
    }

    public int getValue() {
        return value;
    }
}
