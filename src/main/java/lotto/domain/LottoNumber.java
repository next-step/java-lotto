package lotto.domain;

import java.util.Objects;

import static java.lang.String.format;

public class LottoNumber {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final String ILLEGAL_ARGUMENT_FORMAT = "로또 번호는 %d와(과) %d 사이의 숫자만 가능합니다.";
    private static final String ILLEGAL_ARGUMENT_MESSAGE
            = format(ILLEGAL_ARGUMENT_FORMAT, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);

    private int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber from(int value) {
        return new LottoNumber(value);
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

    private void validate(int value) {
        if (MIN_LOTTO_NUMBER > value || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
    }
}
