package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Numbers;

public class NumberSelectionStrategyImpl implements NumberSelectionStrategy {

    @Override
    public Numbers collectNumbers() {
        return Numbers.builder()
                .range(Numbers.START_NUM, Numbers.END_NUM)
                .shuffle()
                .limit(Lotto.SIZE)
                .sort()
                .build();
    }
}
