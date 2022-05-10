package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();
    private int value;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber create(String input) {
        return CACHE.get(Integer.parseInt(input));
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
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
        return Objects.hash(value);
    }
}
