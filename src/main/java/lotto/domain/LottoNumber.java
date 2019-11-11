package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private static final String CONVERT_NUMBER_ERROR_MESSAGE = "숫자 이외의 값이 입력 되었습니다.";

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        this.number = convertNumber(number);
    }

    private static int convertNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new  NumberFormatException(CONVERT_NUMBER_ERROR_MESSAGE);
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
        return String.valueOf(number);
    }
}
