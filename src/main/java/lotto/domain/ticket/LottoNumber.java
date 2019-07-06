package lotto.domain.ticket;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoNumber {
    public static final Long LOTTO_NUMBER_MIN = 1L;
    public static final Long LOTTO_NUMBER_MAX = 45L;
    private static final Map<Long, LottoNumber> lottoNumberPool;
    private Long number;

    static {
        lottoNumberPool = Collections.unmodifiableMap(
                LongStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
                        .boxed()
                        .collect(Collectors.toMap(number -> number, LottoNumber::new, (number1, number2) -> number1)));
    }

    LottoNumber(long number) {
        this.number = number;
    }

    public static LottoNumber of(long number) {
        validate(number);
        return lottoNumberPool.get(number);
    }

    private static void validate(long number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("Invalid lotto number");
        }
    }

    public Long get() {
        return number;
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
