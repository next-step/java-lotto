package lotto.domain.lotto.ticket;

import java.util.Objects;

public class LottoNumber {
    private final static String LOTTO_NUMBER_ERROR = "로또번호는 숫자만 입력해주세요.";
    private final static String LOTTO_NUMBER_RANGE_ERROR = "1에서 45사이의 숫자만 입력해주세요.";
    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        this.number = validate(parseInt(number));
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

    private int validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
        return number;
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
