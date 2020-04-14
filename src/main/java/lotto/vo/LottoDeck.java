package lotto.vo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDeck {

    private static final int LOTTO_RANGE_START = 1;
    private static final int LOTTO_RANGE_END = 45;

    private static final int LOTTO_INDEX_START = 0;
    private static final int LOTTO_INDEX_TO = 5;

    private static final List<Integer> lottoDeck = IntStream.rangeClosed(LOTTO_RANGE_START, LOTTO_RANGE_END)
            .boxed().collect(Collectors.toList());

    public LottoDeck() {
        Collections.shuffle(lottoDeck);
    }

    public List<Integer> pick() {
        return lottoDeck.subList(LOTTO_INDEX_START, LOTTO_INDEX_TO);
    }
}
