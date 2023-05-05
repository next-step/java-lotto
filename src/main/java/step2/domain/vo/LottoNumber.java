package step2.domain.vo;

import java.util.Objects;

public class LottoNumber {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1부터 45까지의 숫자만 가능합니다. 현재 숫자:";

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number > LOTTO_END_NUMBER || number < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION_MESSAGE + " " + number);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;

        return Objects.equals(getNumber(), lottoNumber.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
