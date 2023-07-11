package lottogame;

import java.text.MessageFormat;
import java.util.Objects;

public final class LottoNumber {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private final int lottoNumber;

    public LottoNumber(final Integer value) {
        validateRange(value);
        this.lottoNumber = value;
    }

    // TODO : try - catch & constructor 2개에 대한 더  나은 고민 필요
    public LottoNumber(final String text) {
        int value = Integer.parseInt(text.trim());
        validateRange(value);
        this.lottoNumber = value;
    }

    private void validateRange(int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(
                MessageFormat.format("{0}이상 {1}이하의 숫자여야합니다", LOWER_BOUND, UPPER_BOUND)
            );
        }
    }

    public boolean isSame(LottoNumber number) {
        return this.equals(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
