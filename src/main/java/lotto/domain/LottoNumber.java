package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final LottoNumber[] DEFAULT_NUMBERS = new LottoNumber[MAX_NUMBER_RANGE];

    static {
        for (int i = MIN_NUMBER_RANGE; i <= MAX_NUMBER_RANGE; i++) {
            DEFAULT_NUMBERS[i - 1] = new LottoNumber(i);
        }
    }

    private final int number;

    private LottoNumber(int number) {
        validateInRange(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateInRange(number);
        return DEFAULT_NUMBERS[number - 1];
    }

    public static LottoNumber of(String number) {
        return of(Integer.parseInt(number));
    }

    private static void validateInRange(int number) {
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException();
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
        return String.valueOf(number);
    }

}
