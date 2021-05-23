package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> CACHE = createCache();

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {

        if (!CACHE.containsKey(number)) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자만 사용해야 합니다.");
        }

        return CACHE.get(number);
    }

    public int value() {
        return number;
    }

    private static Map<Integer, LottoNumber> createCache() {
        return Stream.iterate(1, i -> i + 1)
                     .limit(45)
                     .collect(
                         collectingAndThen(toMap(i -> i, LottoNumber::new),
                                           Collections::unmodifiableMap));
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
        return number;
    }
}
