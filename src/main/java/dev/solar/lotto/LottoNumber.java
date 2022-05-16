package dev.solar.lotto;

import java.util.Objects;
import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Random random = new Random();
    private final int value;

    public static LottoNumber random() {
        return new LottoNumber(random.nextInt(MAX_NUMBER) + MIN_NUMBER);
    }

    public LottoNumber(final int number) {
        validate(number);
        this.value = number;
    }

    public LottoNumber(final String number) {
        this(toNumber(number));
    }

    private static int toNumber(final String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }

        return Integer.parseInt(number);
    }

    private static boolean isNumber(final String input) {
        String regExp = "^[0-9]+$";

        return input.matches(regExp);
    }

    public void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호 범위는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + " 입니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
               "value=" + value +
               '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(value, o.value);
    }
}
