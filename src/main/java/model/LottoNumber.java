package model;

import java.util.Objects;

public class LottoNumber {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final String INVALID_NUMBER = "로또의 숫자는 1~45 사이의 숫자여야 한다.";
    private int number;

    public LottoNumber(int number) {
        checkValidLottoNumber(number);
        this.number = number;
    }

    public LottoNumber(String value) {
        this(Integer.parseInt(value));
    }

    private void checkValidLottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoNumber num = (LottoNumber) o;
        return number == num.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
