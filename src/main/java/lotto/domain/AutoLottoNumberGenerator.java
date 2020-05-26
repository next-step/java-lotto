package lotto.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    public static final int LOTTO_NUMBER_BEGIN_BOUND = 1;
    public static final int LOTTO_NUMBER_END_BOUND = 46;
    public static final int COUNT_OF_GENERATE_NUMBER = 6;

    @Override
    public List<Integer> generate() {
        return ThreadLocalRandom.current().ints(LOTTO_NUMBER_BEGIN_BOUND, LOTTO_NUMBER_END_BOUND)
                .distinct()
                .limit(COUNT_OF_GENERATE_NUMBER)
                .sorted()
                .boxed()
                .collect(toList());
    }
}
