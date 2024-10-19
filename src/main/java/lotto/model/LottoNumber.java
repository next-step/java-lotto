package lotto.model;

import java.util.Objects;

public class LottoNumber {

    public static final String NUMBER_INIT_ERROR_MESSAGE = "0 ~ 45 사이에 숫자를 입력하세요!";
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 45;
    private int number;

    public LottoNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public LottoNumber(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new IllegalArgumentException(NUMBER_INIT_ERROR_MESSAGE);
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return number + "";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
