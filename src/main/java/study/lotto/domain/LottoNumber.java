package study.lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException(
                    "숫자는 " + MIN_NUMBER + "이상 " + MAX_NUMBER + "이하여야 합니다.");
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override public int hashCode() {
        return Objects.hash(number);
    }
}
