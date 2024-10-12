package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(final String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(final int number) {
        if(number <= 0 || number > 45){
            throw new IllegalArgumentException("로또 숫자는 1이상 45이하 범위 이내에서 입력하세요");
        }
        this.number = number;
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
