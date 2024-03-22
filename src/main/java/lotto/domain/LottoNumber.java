package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        if (Rule.isNotInRange(number)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자만 가능합니다.");
        }
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) object;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
