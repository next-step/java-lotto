package autolotto.domain;

import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final int number;

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            cache.put(number, new LottoNumber(number));
        }
    }

    public static LottoNumber of(int number) {
        return of(String.valueOf(number));
    }

    public static LottoNumber of(String number) {
        if (!LottoNumberPattern.match(number)) {
            throw new LottoException(LottoExceptionCode.INVALID_LOTTO_NUMBER_TYPE, number);
        }
        return cache.get(Integer.parseInt(number));
    }

    private LottoNumber(int number) {
        this(String.valueOf(number));
    }

    private LottoNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    private int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.getNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
