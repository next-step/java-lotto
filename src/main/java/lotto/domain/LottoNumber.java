package lotto.domain;

import java.util.Comparator;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private final int number;

    public LottoNumber(int number) {
        checkValidation(number);
        this.number = number;
    }

    private static void checkValidation(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("Wrong number");
        }
    }

    public static LottoNumber of(String number) {
        return new LottoNumber(Integer.parseInt(number));
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
        return Integer.compare(number, o.number);
    }
}
