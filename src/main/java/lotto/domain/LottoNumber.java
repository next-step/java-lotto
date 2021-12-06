package lotto.domain;

import static utils.IntegerValidator.getNumberIfRange;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    private final int number;

    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .forEach(number -> cache.put(number, new LottoNumber(number)));
    }

    private LottoNumber(int number) {
        this.number = getNumberIfRange(number, MIN_NUMBER, MAX_NUMBER);
    }

    public static LottoNumber create(int number) {
        return cache.getOrDefault(number, new LottoNumber(number));
    }

    public int getNumber() {
        return number;
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
}
