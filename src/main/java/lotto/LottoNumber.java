package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number){
        validateLottoNumber(number);
        this.number = number;
    }

    private static boolean validateLottoNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("유효한 번호가 아닙니다.");
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
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
        return Integer.compare(this.number, o.number);
    }
}
