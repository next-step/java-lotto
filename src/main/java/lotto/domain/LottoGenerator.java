package lotto.domain;

import lotto.vo.LottoDeck;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private final LottoDeck lottoDeck;

    public LottoGenerator() {
        lottoDeck = new LottoDeck();
    }

    public List<Integer> create() {
        final List<Integer> picked = lottoDeck.pick();
        Collections.sort(picked);
        return picked;
    }
}
