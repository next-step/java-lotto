package lotto.domain;

import java.util.Objects;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class LottoNumber {
    private int number;

    public LottoNumber(int number) {
        verify(number);

        this.number = number;
    }

    private void verify(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("로또 숫자는 1부터 45까지의 숫자만을 허용합니다.");
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
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
