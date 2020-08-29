package step4.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_START_NUMBER_VALUE = 1;
    public static final int LOTTO_LAST_NUMBER_VALUE = 45;

    private final int number;

    public LottoNumber(int number) {
        if (number < LOTTO_START_NUMBER_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1이상의 숫자로 이루어져야 합니다.");
        }
        if (number > LOTTO_LAST_NUMBER_VALUE) {
            throw new IllegalArgumentException("로또 번호는 45이하의 숫자로 이루어져야 합니다.");
        }
        this.number = number;
    }

    public int getNumber() {
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
    public int compareTo(LottoNumber number) {
        if (this.number > number.number) {
            return 1;
        }
        if (this.number < number.number) {
            return -1;
        }
        return 0;
    }
}
