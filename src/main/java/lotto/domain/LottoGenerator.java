package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_SIZE_BOUND = 6;
    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private static final List<Integer> LOTTO = IntStream.range(LOTTO_MINIMUM_BOUND,
            LOTTO_MAXIMUM_BOUND + LOTTO_MINIMUM_BOUND)
        .boxed()
        .collect(Collectors.toList());

    public LottoGenerator() {
    }

    public Set<Integer> generateLotto() {
        Collections.shuffle(LOTTO);
        List<Integer> cut = LOTTO.subList(0, LOTTO_SIZE_BOUND);
        return new HashSet<>(cut);
    }
}
