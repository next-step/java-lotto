package lotto.domain;

import lotto.exception.IllegalLottoNumberException;

import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final int number;
    private static final LottoNumber[] lottoNumberCache = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .toArray(LottoNumber[]::new);

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String number) {
        int parseInt = Integer.parseInt(number);
        validate(parseInt);
        if (lottoNumberCache[parseInt] != null) {
            return lottoNumberCache[parseInt];
        }
        return new LottoNumber(parseInt);
    }

    public int initNumber() {
        return number;
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

    @Override
    public int compareTo(LottoNumber number) {
        return this.number - number.initNumber();
    }

    private static void validate(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalLottoNumberException(number);
        }
    }
}
