package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final List<LottoNumber> NUMBER_POOL =
            IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                    .mapToObj(LottoNumber::valueOf)
                    .collect(Collectors.toList());

    private static final int NUMBER_LIMIT_COUNT = 6;

    private LottoNumberGenerator() {
    }

    public static List<LottoNumber> generate() {
        Collections.shuffle(NUMBER_POOL);

        return NUMBER_POOL.stream()
                .limit(NUMBER_LIMIT_COUNT)
                .collect(Collectors.toList());
    }
}
