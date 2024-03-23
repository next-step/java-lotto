package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoValidator.*;

public class LottoNumber {
    public static final String INVALID_LOTTO_NUMBER_BOUND_MESSAGE = "로또 번호는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + "이하의 숫자만 입력할 수 있습니다.";

    private final int value;

    private LottoNumber(int value) {
        if (isInvalidLottoNumberBound(value)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }

        this.value = value;
    }

    public static LottoNumber valueOf(int value) {
        return new LottoNumber(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
