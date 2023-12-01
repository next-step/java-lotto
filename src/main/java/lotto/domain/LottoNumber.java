package lotto.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private final static LottoNumber[] CACHE = new LottoNumber[END_NUMBER + 1];
    static {
        IntStream.range(START_NUMBER, END_NUMBER + 1)
                .forEach(element -> CACHE[element] = new LottoNumber(element));
    }

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        if (number < START_NUMBER || END_NUMBER < number) {
            throw new IllegalArgumentException("Lotto number is more than 1 and less then 46");
        }
        return CACHE[number];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        LottoNumber other = (LottoNumber) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(number, other.number);
    }

    public void checkDuplicateNumber(LottoNumber other) {
        if (getResultIfEqual(other) == 1) {
            throw new IllegalArgumentException("Input duplicate lotto number");
        }
    }

    public int getResultIfEqual(LottoNumber other) {
        if (number == other.number) {
            return 1;
        }
        return 0;
    }

    public int getLottoNumber() { return number; }
}
