package lotto.domain;


import lotto.strategy.NumberStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto(NumberStrategy numberStrategy) {
        lotto = new ArrayList<>(numberStrategy.getNumbers());
        Collections.sort(lotto);
    }

    public long matchCnt(Lotto winningLotto) {
        return lotto.stream()
                .filter(winningLotto.getLotto()::contains)
                .count();
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
