package lotto.domain.service;

import lotto.domain.repository.Numbers;

public class NumberSelectionStrategyImpl implements NumberSelectionStrategy {

    @Override
    public Numbers collectNumbers() {
        return Numbers.builder()
                .range(Numbers.START_NUM, Numbers.END_NUM)
                .shuffle()
                .limit(Numbers.SIZE)
                .sort()
                .build();
    }
}
