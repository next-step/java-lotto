package lotto.domain;

public class NumberSelectionStrategyImpl implements NumberSelectionStrategy {
    public static final int START_INCLUSIVE = 1;
    public static final int END_EXCLUSIVE = 46;
    public static final int FROM_IDX = 0;
    public static final int TO_IDX = 5;

    @Override
    public Numbers collectNumbers() {
        return Numbers.builder()
                .range(START_INCLUSIVE, END_EXCLUSIVE)
                .shuffle()
                .subNumbers(FROM_IDX, TO_IDX)
                .sort()
                .build();
    }
}
