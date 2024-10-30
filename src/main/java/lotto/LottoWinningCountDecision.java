package lotto;

import java.util.Arrays;

public enum LottoWinningCountDecision {
    THREE(5, 5000),
    FOUR(4, 50000),
    FIVE(3, 1500000),
    FIVEBONUS(2, 30000000),
    SIX(1, 2000000000);

    private int rank;
    private int lottoWinningAmount;

    LottoWinningCountDecision(int rank, int lottoWinningAmount) {
        this.rank = rank;
        this.lottoWinningAmount = lottoWinningAmount;
    }

    public static int convertMatchingRankToAmount(int rank) {
        return Arrays.stream(values()).filter(i -> i.rank == rank)
                .mapToInt(i -> i.lottoWinningAmount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
