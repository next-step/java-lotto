package lotto;

import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private int number;

    private LottoNumber(int number) {
        verify(number);
        this.number = number;
    }

    private void verify(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(String
                    .format("%d는 1~45 숫자 사이의 번호가 아닙니다", number));
        }
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber of(int input) {
        return new LottoNumber(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
