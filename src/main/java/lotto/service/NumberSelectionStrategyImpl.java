package lotto.service;

import lotto.domain.Numbers;

public class NumberSelectionStrategyImpl implements NumberSelectionStrategy {

    @Override
    public Numbers collectNumbers(int size) {
        return Numbers.builder()
                .range(Numbers.START_NUM, Numbers.END_NUM)
                .shuffle()
                .limit(size)
                .sort()
                .build();
    }
}
