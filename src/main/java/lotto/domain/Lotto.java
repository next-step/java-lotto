package lotto.domain;


import lotto.strategy.NumberStrategy;

import java.util.List;

public class Lotto {

    private final List<Integer> lotto;

    public Lotto(NumberStrategy numberStrategy) {
        lotto = numberStrategy.getNumbers();
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
