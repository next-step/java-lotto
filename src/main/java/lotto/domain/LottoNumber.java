/*
 * 로또의 숫자를 나타내는 원시값 포장 클래스
 * */
package lotto.domain;

import java.util.Objects;

import static lotto.util.Message.ILLEGAL_NUMBER;

public class LottoNumber {

    public static int LOWER_LOTTONUMBER_BOUND = 1;
    public static int UPPER_LOTTONUMBER_BOUND = 45;

    private int number;

    public LottoNumber(int number) {
        if (isLottoNumber(number)) {
            this.number = number;
        }
    }

    public boolean isLottoNumber(int number) {
        if (number < LOWER_LOTTONUMBER_BOUND || number > UPPER_LOTTONUMBER_BOUND) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
