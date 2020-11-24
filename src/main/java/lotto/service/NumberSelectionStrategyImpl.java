package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Numbers;

public class NumberSelectionStrategyImpl implements NumberSelectionStrategy {

    @Override
    public Numbers collectNumbers() {
        return Numbers.builder()
                .range(Number.START_NUM, Number.END_NUM)
                .shuffle()
                .limit(Lotto.SIZE)
                .sort()
                .build();
    }
}
