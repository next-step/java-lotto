package lotto.domain;

import java.util.Objects;
import lotto.settings.LottoSettings;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final LottoNumberCache cache = LottoNumberCache.getInstance();
    private final int number;

    private LottoNumber(int value) {
        if (outOfRange(value)) {
            throw new IllegalArgumentException("로또의 숫자는 1~45사이의 숫자여야 합니다");
        }
        this.number = value;
    }

    private static boolean outOfRange(int value) {
        return !LottoSettings.isNumberInValidRange(value);
    }

    public static LottoNumber of(int value) {
        return cache.find(value).orElseGet(() -> addToCache(value));
    }

    private static LottoNumber addToCache(int value) {
        LottoNumber result = new LottoNumber(value);
        cache.add(value, result);
        return result;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
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
