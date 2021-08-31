package lotto.number;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MAX = 45;
    public static final int MIN = 1;

    private final int number;

    public LottoNumber(int number) {
        isValid(number);
        this.number = number;
    }

    public int value() {
        return this.number;
    }

    private void isValid(int number) {
        if (isAboveMax(number) || isUnderMin(number)) {
            throw new IllegalArgumentException("로또 숫자는 1 이상, 45 이하의 정수입니다.");
        }
    }

    private boolean isAboveMax(int number) {
        return number > MAX;
    }

    private boolean isUnderMin(int number) {
        return number < MIN;
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
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }
}
