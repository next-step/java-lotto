package Lotto.model;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String LOTTO_CONSTRUCOR_ERROR_MESSAGE = "로또의 숫자는 1~45의 값만 가질 수 있씁니다.";
    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number > LOTTO_MAX_NUMBER || number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(LOTTO_CONSTRUCOR_ERROR_MESSAGE);
        }
    }

    ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
