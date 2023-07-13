package lotto.domain.game;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.OptionalInt;

public final class LottoNumber {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private final int number;

    public LottoNumber(final Integer value) {
        validateRange(value);
        this.number = value;
    }

    public LottoNumber(final String text) {
        int value = OptionalInt.of(Integer.parseInt(text.trim()))
            .orElseThrow(() -> new NumberFormatException("숫자를 입력해 주세요"));
        validateRange(value);
        this.number = value;
    }

    private void validateRange(final int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(
                MessageFormat.format("{0}이상 {1}이하의 숫자여야합니다", LOWER_BOUND, UPPER_BOUND)
            );
        }
    }

    public int getNumber() {
        return number;
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
