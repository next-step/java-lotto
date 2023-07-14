package lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    static final int LOTTO_START = 1;
    static final int LOTTO_END = 45;
    private static final Map<Integer, LottoNumber> lottoNumberCache = IntStream.rangeClosed(LOTTO_START, LOTTO_END)
            .boxed()
            .collect(Collectors.toMap(number -> number, LottoNumber::new));
    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        verify(number);
        return lottoNumberCache.get(number);
    }

    private static void verify(final Integer number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException("lotto number should in range " + LOTTO_START + "~" + LOTTO_END);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
