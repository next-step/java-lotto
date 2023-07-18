package lotto.model;

import java.util.Objects;

public final class LottoNumber {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final int value;

    private LottoNumber(final int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber of(final int value) {
        return new LottoNumber(value);
    }

    private void validate(final int value) {
        if (value < MINIMUM_NUMBER || value > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("잘못된 로또 번호입니다. 로또번호는 1이상 45이하의 정수를 입력하셔야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
