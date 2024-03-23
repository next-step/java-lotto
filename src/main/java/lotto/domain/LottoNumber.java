package lotto.domain;

import lotto.exception.IllegalLottoNumberException;

import java.util.Objects;

public class LottoNumber {

    public static final int NUMBER_RANGE_FROM = 1;
    public static final int NUMBER_RANGE_TO = 45;

    private final int number;

    public static LottoNumber of(int number) {
        validateNumberRange(number);
        return LottoNumberCache.cache[number];
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    private static void validateNumberRange(int number) throws IllegalLottoNumberException {
        if (notInRange(number)) {
            throw new IllegalLottoNumberException(NUMBER_RANGE_FROM, NUMBER_RANGE_TO, number);
        }
    }

    private static boolean notInRange(int number) {
        return number < NUMBER_RANGE_FROM || number > NUMBER_RANGE_TO;
    }

    public int get() {
        return this.number;
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

    private static class LottoNumberCache {
        static final int low = NUMBER_RANGE_FROM;
        static final int high = NUMBER_RANGE_TO;
        static final LottoNumber[] cache;

        static {
            cache = new LottoNumber[(high - low) + 2]; // cache array index start 'from' number
            for (int number = low; number < cache.length; number++) {
                cache[number] = new LottoNumber(number);
            }
        }

        private LottoNumberCache() {

        }

    }
}
