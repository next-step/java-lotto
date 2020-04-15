package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;

    private static final int LOTTO_INDEX_START = 0;
    private static final int LOTTO_INDEX_TO = 6;

    private static final List<Integer> lottoDeck = IntStream.rangeClosed(LOTTO_RANGE_START, LOTTO_RANGE_END)
            .boxed().collect(Collectors.toList());

    public int[] create() {
        Collections.shuffle(lottoDeck);
        final List<Integer> picked = lottoDeck.subList(LOTTO_INDEX_START, LOTTO_INDEX_TO);
        Collections.sort(picked);
        return picked.stream().mapToInt(Integer::intValue).toArray();
    }
}
