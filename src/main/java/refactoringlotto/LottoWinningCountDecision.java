package refactoringlotto;

import java.util.Arrays;

public enum LottoWinningCountDecision {
    THREE(4,5000),
    FOUR(3,50000),
    FIVE(2,1500000),
    SIX(1,2000000000);


    private int rank;
    private int lottoWinningAmount;


    LottoWinningCountDecision(int rank, int lottoWinningAmount) {
        this.rank = rank;
        this.lottoWinningAmount = lottoWinningAmount;
    }

    public static int convertMatchingRankToAmount(int rank) {
        return Arrays.stream(values()).filter(i -> i.rank == rank)
                .mapToInt(i-> i.lottoWinningAmount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }



}
