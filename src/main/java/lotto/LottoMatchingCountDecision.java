package lotto;

import java.util.Arrays;

public enum LottoMatchingCountDecision {
    THREE(Constants.MATCHING_THREE_COUNT,Constants.LOTTO_THREE_COUNT_INDEX),
    FOUR(Constants.MATCHING_FOUR_COUNT,Constants.LOTTO_FOUR_COUNT_INDEX),
    FIVE(Constants.FIVE_COUNT_NUMBER,Constants.LOTTO_FIVE_COUNT_INDEX),
    SIX(Constants.SIX_COUNT_NUMBER,Constants.LOTTO_SIX_COUNT_INDEX);


    private int numberCount;
    private int convertingNumberIndex;


    LottoMatchingCountDecision(int numberCount, int convertingNumberIndex) {
        this.numberCount = numberCount;
        this.convertingNumberIndex = convertingNumberIndex;
    }

    public static int convertMatchingNumberToIndex(int numberCount) {
        return Arrays.stream(values()).filter(i -> i.numberCount == numberCount)
                .mapToInt(i-> i.convertingNumberIndex)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static class Constants {
        public static final int LOTTO_THREE_COUNT_INDEX = 0;
        public static final int LOTTO_FOUR_COUNT_INDEX = 1;
        public static final int LOTTO_FIVE_COUNT_INDEX = 2;
        public static final int LOTTO_SIX_COUNT_INDEX = 3;
        public static final int MATCHING_THREE_COUNT = 3;
        public static final int MATCHING_FOUR_COUNT = 4;
        public static final int FIVE_COUNT_NUMBER = 5;
        public static final int SIX_COUNT_NUMBER = 6;
    }
}
