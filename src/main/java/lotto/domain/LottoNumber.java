package lotto.domain;

import java.util.stream.IntStream;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;

    public static final int MAX_LOTTO_NUMBER = 45;

    private static final LottoNumber[] LOTTO_NUMBER_CACHE = new LottoNumber[MAX_LOTTO_NUMBER + 1];

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> LOTTO_NUMBER_CACHE[number] = new LottoNumber(number));
    }

    private final int number;

    private LottoNumber(final int number) {
        validateRange(number);
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        validateRange(number);
        return LOTTO_NUMBER_CACHE[number];
    }

    private static void validateRange(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1-45 사이 숫자입니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
