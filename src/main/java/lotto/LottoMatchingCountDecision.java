package lotto;

public enum LottoMatchingCountDecision {
    THREE(3,Constants.LOTTO_THREE_COUNT_INDEX),
    FOUR(4,Constants.LOTTO_FOUR_COUNT_INDEX),
    FIVE(5,Constants.LOTTO_FIVE_COUNT_INDEX),
    SIX(6,Constants.LOTTO_SIX_COUNT_INDEX);


    private int numberCount;
    private int convertingNumberIndex;


    LottoMatchingCountDecision(int numberCount, int convertingNumberIndex) {
        this.numberCount = numberCount;
        this.convertingNumberIndex = convertingNumberIndex;
    }

    public static int convertMatchingNumberToIndex(int numberCount) {
        for (LottoMatchingCountDecision lottoMatchingCountDecision :values()) {
            if (lottoMatchingCountDecision.numberCount == numberCount) {
                return lottoMatchingCountDecision.convertingNumberIndex;
            }
        }
        throw new IllegalArgumentException();
    }

    private static class Constants {
        public static final int LOTTO_THREE_COUNT_INDEX = 0;
        public static final int LOTTO_FOUR_COUNT_INDEX = 1;
        public static final int LOTTO_FIVE_COUNT_INDEX = 2;
        public static final int LOTTO_SIX_COUNT_INDEX = 3;
    }
}
