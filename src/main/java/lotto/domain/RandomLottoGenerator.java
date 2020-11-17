package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int RANGE_FIRST_INDEX = 0;
    private static final int RANGE_LAST_INDEX = 6;

    private static List<Integer> LOTTO_RANGE = IntStream
            .range(1, 45)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public Set<Integer> create() {
        return random();
    }

    private static Set<Integer> random() {
        Collections.shuffle(LOTTO_RANGE);
        return new HashSet<>(LOTTO_RANGE.subList(RANGE_FIRST_INDEX, RANGE_LAST_INDEX));
    }
}
