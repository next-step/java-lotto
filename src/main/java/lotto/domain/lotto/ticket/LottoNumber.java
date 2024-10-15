package lotto.domain.lotto.ticket;

import java.util.Objects;

public class LottoNumber {
    private final static String LOTTO_NUMBER_ERROR = "로또번호는 숫자만 입력해주세요.";
    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        this.number = parseInt(number);
    }

    public int getNumber() {
        return number;
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new NumberFormatException(LOTTO_NUMBER_ERROR);
        }
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

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
