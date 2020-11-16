package lotto.domain;

public class NumberSelectionStrategyImpl implements NumberSelectionStrategy {
    public static final int FROM_IDX = 0;
    public static final int TO_IDX = 6;

    @Override
    public Numbers collectNumbers() {
        return Numbers.builder()
                .range(Numbers.Builder.LOTTO_START_NUM, Numbers.Builder.LOTTO_END_NUM)
                .shuffle()
                .subNumbers(FROM_IDX, TO_IDX)
                .sort()
                .build();
    }
}
