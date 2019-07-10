package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public final class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private int number;

    static {
        IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .forEach(i -> lottoNumbers.put(i, new LottoNumber(i)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }

        if (number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
        return lottoNumbers.get(number);
    }

    public static LottoNumber of(String number) {
        return LottoNumber.of(Integer.parseInt(number));
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
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
        return String.valueOf(this.number);
    }
}