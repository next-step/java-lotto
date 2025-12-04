package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .forEach(i -> CACHE.put(i, new LottoNumber(i)));
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        validate(lottoNumber);
        return CACHE.get(lottoNumber);
    }

    private static void validate(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LottoNumber that = (LottoNumber) object;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
