package lotto.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private static final LottoNumber[] NUMBERS = new LottoNumber[MAXIMUM_NUMBER + 1];

    private int value;

    static {
        IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .forEach(number -> NUMBERS[number] = new LottoNumber(number))
        ;
    }

    private LottoNumber(final int value) {
        this.value = value;
    }

    public static LottoNumber from(final int value) {
        validate(value);
        return NUMBERS[value];
    }

    public int get() {
        return value;
    }

    private static void validate(final int value) {
        if (value < MINIMUM_NUMBER || value > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
