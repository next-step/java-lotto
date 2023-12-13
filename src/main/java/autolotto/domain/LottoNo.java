package autolotto.domain;

import java.util.Objects;

public class LottoNo {
    private final int number;

    public LottoNo(int number) {
        this.number = number;
        validateRange();
    }

    public int getNumber() {
        return number;
    }

    private void validateRange() {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1~ 45까지의 숫자 입니다.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
