package lotto;

import java.util.Objects;

public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        checkValidLottoNumber(number);
        this.number = number;
    }

    private void checkValidLottoNumber(int number) {
        if (number <= 0 || number >= 46) {
            throw new IllegalArgumentException("로또의 숫자는 1~45 사이의 숫자이어야 합니다.");
        }
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

}
