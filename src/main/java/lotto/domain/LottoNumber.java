package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    public static final int MAX_BOUND = 45;
    public static final int MIN_BOUND = 1;
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "로또 숫자가 범위 밖입니다.";
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = initializeLottoNumberCache();

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    private static Map<Integer, LottoNumber> initializeLottoNumberCache() {
        Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();
        for (int number = MIN_BOUND; number < MAX_BOUND + 1; number++) {
            lottoNumberCache.put(number, new LottoNumber(number));
        }
        return lottoNumberCache;
    }

    public static LottoNumber valueOf(int value) {
        if (value < MIN_BOUND || value > MAX_BOUND) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
        return LOTTO_NUMBER_CACHE.get(value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
