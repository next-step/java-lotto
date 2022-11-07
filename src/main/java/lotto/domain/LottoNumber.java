package lotto.domain;

import java.util.Objects;

public final class LottoNumber {

    public static final int MIN = 1;
    public static final int MAX = 45;

    private static final class LottoNumberCache {

        private static final LottoNumber[] cache;

        static {
            cache = new LottoNumber[MAX - MIN + 1];
            int j = MIN;
            for (int i = 0; i < cache.length; i++) {
                cache[i] = new LottoNumber(j++);
            }
        }

        private LottoNumberCache() {
        }

        private static boolean contains(final int value) {
            return cache[0].intValue() <= value && value <= cache[cache.length - 1].intValue();
        }

        private static LottoNumber get(final int value) {
            return cache[value - 1];
        }
    }

    private final int value;

    private LottoNumber(final int value) {
        validateValue(value);
        this.value = value;
    }

    private static void validateValue(final int value) {
        if (value < MIN || value > MAX) {
            throw new LottoException(
                String.format("value should be in range [%d..%d]", MIN, MAX));
        }
    }

    public static LottoNumber valueOf(final int value) {
        if (LottoNumberCache.contains(value)) {
            return LottoNumberCache.get(value);
        }
        return new LottoNumber(value);
    }

    public int intValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("{%d}", value);
    }

}
