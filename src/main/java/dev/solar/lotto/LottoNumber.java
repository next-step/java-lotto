package dev.solar.lotto;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Random random = new Random();
    private final int value;

    public static LottoNumber random() {
        return new LottoNumber(random.nextInt(MIN_NUMBER + MAX_NUMBER) + MIN_NUMBER);
    }

    public LottoNumber(final int number) {
        validate(number);
        this.value = number;
    }

    public void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호 범위는 " + MIN_NUMBER + " ~ " + MAX_NUMBER + " 입니다.");
        }
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
}
