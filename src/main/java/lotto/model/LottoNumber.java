package lotto.model;

import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_NUBER_MIN = 1;
    public static final int LOTTO_NUBER_MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < LOTTO_NUBER_MIN || number > LOTTO_NUBER_MAX) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하의 숫자이어야 합니다.");
        }
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
