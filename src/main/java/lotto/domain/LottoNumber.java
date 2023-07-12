package lotto.domain;

import java.text.MessageFormat;
import java.util.Objects;

public final class LottoNumber {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private final int lottoNumber;

    public LottoNumber(final int value) {
        validateRange(value);
        this.lottoNumber = value;
    }

    public LottoNumber(final String text) {
        validateBlank(text);
        lottoNumber = Integer.parseInt(text.trim());
        validateRange(lottoNumber);
    }

    private void validateBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    private void validateRange(final int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(
                MessageFormat.format("{0}이상 {1}이하의 숫자여야합니다", LOWER_BOUND, UPPER_BOUND)
            );
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
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
