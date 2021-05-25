package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if (isInValidNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 1에서 45사이의 숫자값만 입력할 수 있습니다.");
        }
        this.number = number;
    }

    private boolean isInValidNumber(int number) {
        return !(number >= Lotto.MIN && number <= Lotto.MAX);
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
}
