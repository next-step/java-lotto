package lotto.domain.ticket;

import lotto.common.PositiveNumber;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoNumber {
    public static final long LOTTO_NUMBER_MIN = 1L;
    public static final long LOTTO_NUMBER_MAX = 45L;
    private static final Map<PositiveNumber, LottoNumber> lottoNumberPool;
    private PositiveNumber number;

    static {
        lottoNumberPool = Collections.unmodifiableMap(
                LongStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
                        .mapToObj(PositiveNumber::of)
                        .collect(Collectors.toMap(number -> number, LottoNumber::new, (number1, number2) -> number1)));
    }

    LottoNumber(PositiveNumber number) {
        this.number = number;
    }

    public static LottoNumber of(PositiveNumber number) {
        validate(number);
        return lottoNumberPool.get(number);
    }

    private static void validate(PositiveNumber number) {
        if (number.get() < LOTTO_NUMBER_MIN || number.get() > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("Invalid lotto number");
        }
    }

    public long get() {
        return number.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
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
