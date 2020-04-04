package study.lotto.domain;

import study.lotto.domain.exception.IllegalNumberRangeArgumentException;

import java.util.Objects;

public class Amount {
    private static final String MIN_AMOUNT_ERROR_MESSAGE = "최소 금액은 %d원 입니다.";
    private static final int AMOUNT_MIN = 0;
    private int value;

    public Amount(int value) {
        if (value < AMOUNT_MIN) {
            throw new IllegalNumberRangeArgumentException(
                    String.format(MIN_AMOUNT_ERROR_MESSAGE, AMOUNT_MIN));
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return value == amount1.value;
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
