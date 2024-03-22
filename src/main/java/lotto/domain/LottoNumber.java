package lotto.domain;

import java.util.Objects;

import static lotto.domain.Rule.MAX_NUMBER;
import static lotto.domain.Rule.MIN_NUMBER;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자만 가능합니다.");
        }
        this.number = number;
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
