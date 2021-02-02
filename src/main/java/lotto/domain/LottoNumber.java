package lotto.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final LottoNumber[] LOTTO_NUMBERS = new LottoNumber[MAX_VALUE + 1];

    static {
        IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
                .forEach(i -> LOTTO_NUMBERS[i] = new LottoNumber(i));
    }

    private final int number;

    private LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber of(final String numberString) {
        int number = Integer.parseInt(numberString);
        validate(number);
        return LOTTO_NUMBERS[number];
    }

    public static LottoNumber of(final int number) {
        validate(number);
        return LOTTO_NUMBERS[number];
    }

    private static void validate(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 수만 가능합니다.");
        }
    }

    // TODO: getter 없애기
    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
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