package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoValidator.*;

public class MyNumber {
    public static final String INVALID_LOTTO_NUMBER_BOUND_MESSAGE = "로또 번호는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + "이하의 숫자만 입력할 수 있습니다.";
    public static final String ALREADY_EXIST_LOTTO_NUMBER = "해당 번호는 기본 당첨 번호입니다. 다시 입력해주세요.";

    private final int value;

    private MyNumber(int value) {
        if (isInvalidLottoNumberBound(value)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }

        this.value = value;
    }

    public static MyNumber valueOf(int value) {
        return new MyNumber(value);
    }

    public static MyNumber bonusNumberFrom(int value, LottoNumber winningNumber) {
        MyNumber myNumber = new MyNumber(value);
        if (winningNumber.isContainNumber(myNumber)) {
            throw new IllegalArgumentException(ALREADY_EXIST_LOTTO_NUMBER);
        }
        return myNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNumber myNumber = (MyNumber) o;
        return value == myNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
