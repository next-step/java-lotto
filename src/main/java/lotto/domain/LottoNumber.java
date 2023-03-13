package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_MIN_LIMIT_VALUE = 1;
    private static final int LOTTO_MAX_LIMIT_VALUE = 45;

    private final Integer number;

    public LottoNumber(Integer number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(Integer number) {
        if (number < LOTTO_MIN_LIMIT_VALUE || number > LOTTO_MAX_LIMIT_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45까지 숫자만 선택 가능합니다.");
        }
    }

    public boolean match(final LottoNumber other) {
        return Objects.equals(number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
