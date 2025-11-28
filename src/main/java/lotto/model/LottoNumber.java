package lotto.model;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private final static Map<Integer, LottoNumber> CACHE;

    static {
        CACHE = new ConcurrentHashMap<>();
        IntStream.rangeClosed(1, 45).forEach(i -> CACHE.put(i, new LottoNumber(i)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber another) {
        return Integer.compare(this.number, another.number);
    }

    private static boolean isValid(int number) {
        return CACHE.containsKey(number);
    }

    public static LottoNumber of(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return CACHE.get(number);
    }

    public static LottoNumber of(String input) {
        return of(Integer.parseInt(input));
    }
}
