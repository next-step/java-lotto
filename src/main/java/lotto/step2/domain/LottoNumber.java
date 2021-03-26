package lotto.step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static String MESSAGE_ILLEGAL_NUMBER = "유효범위를 벗어난 숫자입니다.";

    private int number;

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(MESSAGE_ILLEGAL_NUMBER);
        }
        this.number = number;
    }

    public int number() {
        return number;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LottoNumber otherLottoNumber = (LottoNumber) other;
        return number == otherLottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return number - other.number;
    }
}

