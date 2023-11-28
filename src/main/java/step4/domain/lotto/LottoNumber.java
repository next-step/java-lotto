package step4.domain.lotto;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(final int number) {
        checkValidationNumberRange(number);
        this.number = number;
    }

    private void checkValidationNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean hasBonusNumber(final Integer bonusNumber) {
        return number == bonusNumber;
    }

    public int getNumber() {
        return number;
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
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
