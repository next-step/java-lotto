package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private final int number;

    public LottoNumber(int number){
        this.number = number;
        validateNumber();
    }

    public LottoNumber(String number){
        this.number = Integer.parseInt(number);
        validateNumber();
    }

    public void validateNumber() {
        if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
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
        return ""+number;
    }
}
