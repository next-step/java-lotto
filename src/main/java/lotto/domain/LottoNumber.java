package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        checkAvailableNumber(number);
        return LottoNumberCache.cache[number - 1];
    }

    private static void checkAvailableNumber(final int number) {
        if (number < 1 || number > 45) {
            throw new RuntimeException("1 ~ 45 사이의 숫자가 아닙니다.");
        }
    }

    private static class LottoNumberCache {
        static final int MAX = 45;
        static final LottoNumber[] cache = new LottoNumber[MAX];

        static {
            for (int i = 0; i < MAX; i++) {
                cache[i] = new LottoNumber(i + 1);
            }
        }

        private LottoNumberCache() {}
    }


    @Override
    public int compareTo(final LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
