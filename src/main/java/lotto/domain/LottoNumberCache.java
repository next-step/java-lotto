package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberCache {

    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;
    private static final List<LottoNumber> cache;

    static {
        cache = IntStream.rangeClosed(NUMBER_MIN, NUMBER_MAX)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public static LottoNumber getNumber(int number) {
        return cache.get(number - 1);
    }

}
