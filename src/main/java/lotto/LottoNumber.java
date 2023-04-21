package lotto;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        this.number = validRange(number);
    }

    private int validRange(int number) {
        if (isInvalidRange(number)) {
            throw new IllegalArgumentException("숫자는 1 ~ 45 사이의 값만 가질수 있습니다. : " + number);
        }
        return number;
    }

    private boolean isInvalidRange(int number) {
        return number < MIN_NUMBER || MAX_NUMBER < number;
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return number == lottoNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "" + number;
    }

    public static int compare(LottoNumber a, LottoNumber b) {
        if (a.value() > b.value()) {
            return 1;
        }
        if (a.value() < b.value()) {
            return -1;
        }
        return 0;
    }

}
