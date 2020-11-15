package lotto.domain.lotto;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class LottoNumber {
    public static final String LOTTO_NUMBER_INVALID_RANGE = "lotto number must between 1 and 45";
    public static final LottoNumber MAX = LottoNumber.of(45);
    public static final LottoNumber MIN = LottoNumber.of(1);
    
    private final int value;

    private LottoNumber(final int number) {
        checkArgument(number >= 0 && number <= 45, LOTTO_NUMBER_INVALID_RANGE);
        this.value = number;
    }

    public static LottoNumber of(final int number) {
        return new LottoNumber(number);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
