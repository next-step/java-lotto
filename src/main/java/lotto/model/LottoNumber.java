package lotto.model;

import lotto.enumset.ValidateEnum;

import java.util.Objects;

public class LottoNumber {

    private int number;

    public LottoNumber(String number) {
        this.number = rangeValidation(number);
    }

    public int getNumber() {
        return this.number;
    }

    private int rangeValidation(String number) {
        int convertNumber = numberValidation(number);
        if (convertNumber > 45 || convertNumber < 0) {
            throw new RuntimeException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        return convertNumber;
    }

    private int numberValidation(String number) {
        if (ValidateEnum.NUMBER_FORMAT_VALIDATE.isInValid(number)) {
            throw new NumberFormatException("로또 번호는 숫자여야 합니다.");
        }
        return Integer.parseInt(number);
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
