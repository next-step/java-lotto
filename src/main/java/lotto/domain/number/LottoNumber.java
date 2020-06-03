package lotto.domain.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_NUMBER_UNDER_BOUND = 1;
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        validateNumber(number);
        return LottoNumberCache.getLottoNumber(number);
    }

    public int getNumber() {
        return number;
    }

    private static void validateNumber(int number) {
        if (number < LOTTO_NUMBER_UNDER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 값이어야 합니다. - " + number);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    private static class LottoNumberCache {
        private static final List<LottoNumber> cache;

        static {
            cache = new ArrayList<>();

            for (int number = LOTTO_NUMBER_UNDER_BOUND; number <= LOTTO_NUMBER_UPPER_BOUND; number++) {
                cache.add(new LottoNumber(number));
            }
        }

        private static LottoNumber getLottoNumber(int number) {
            return cache.get(number - 1);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
