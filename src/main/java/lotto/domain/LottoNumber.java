package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> CACHE = createCache();

    private static final String LOTTO_NUMBER_RANGE = "로또 번호는 1 ~ 45 사이의 숫자만 사용해야 합니다.";
    private static final int START = 1;
    private static final int ADD_NUM = 1;
    private static final int MAX_SIZE = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {

        if (!CACHE.containsKey(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE);
        }

        return CACHE.get(number);
    }

    public int value() {
        return number;
    }

    private static Map<Integer, LottoNumber> createCache() {
        return Stream.iterate(START, number -> number + ADD_NUM)
                     .limit(MAX_SIZE)
                     .collect(
                         collectingAndThen(toMap(Function.identity(), LottoNumber::new),
                                           Collections::unmodifiableMap));
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
