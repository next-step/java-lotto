package lotto;

import java.util.Objects;

public class LottoNumber {
    public static final String NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1~45 사이의 숫자만 허용합니다.";
    private final int value;

    public LottoNumber(int value) {
        this.validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
