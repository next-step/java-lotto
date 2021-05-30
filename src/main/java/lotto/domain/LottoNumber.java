package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;

    public final int number;

    public LottoNumber(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 1에서 45사이의 숫자값만 입력할 수 있습니다.");
        }
        this.number = number;
    }

    public static boolean isValidNumber(int number) {
        return number >= MIN && number <= MAX;
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
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
