package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        validation(number);
        this.number = number;
    }
    private void validation(int number) {
        if (number < 1 || number > 45) {
            throw new RuntimeException("로또 번호는 1부터 45입니다.");
        }
    }

    public int value() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
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
