package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.data.LottoNumbers;

public class LottoNumberGenerator {
    public static final int MIN_RANGE_NUM = 1;
    public static final int MAX_RANGE_NUM = 45;

    private static final List<Integer> NUMBER_POOL = IntStream.rangeClosed(MIN_RANGE_NUM, MAX_RANGE_NUM)
                                                              .boxed()
                                                              .collect(Collectors.toList());

    public static LottoNumbers sixNumberGenerator() {
        Collections.shuffle(NUMBER_POOL);
        return new LottoNumbers(NUMBER_POOL.stream()
                                           .limit(6)
                                           .collect(Collectors.toList()));
    }
}
