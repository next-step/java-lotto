package lotto.domain;

import java.util.Arrays;

public enum LottoWinningCountDecision {
    THREE(3,4,5000),
    FOUR(4,3,50000),
    FIVE(5,2,1500000),
    SIX(6,1,2000000000);


    private int numberCount;
    private int rank;
    private int lottoWinningAmount;


    LottoWinningCountDecision(int numberCount, int rank, int lottoWinningAmount) {
        this.numberCount = numberCount;
        this.rank = rank;
        this.lottoWinningAmount = lottoWinningAmount;
    }

    public static int convertMatchingNumberToRank(int numberCount) {
        return Arrays.stream(values()).filter(i -> i.numberCount == numberCount)
                .mapToInt(i-> i.rank)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static int convertMatchingRankToAmount(int rank) {
        return Arrays.stream(values()).filter(i -> i.rank == rank)
                .mapToInt(i-> i.lottoWinningAmount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static int convertRankToMatchingNumber(int rank) {
        return Arrays.stream(values()).filter(i -> i.rank == rank)
                .mapToInt(i-> i.numberCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
