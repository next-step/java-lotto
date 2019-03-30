package lotto.domain;

import java.util.Arrays;
import java.util.Map;

import static lotto.domain.RankPrintableFactory.makeRanksForPrint;

public enum Ranking {

    FIRST_CLASS(1, 6, 2_000_000_000),
    SECOND_CLASS(2, 5, 3_000_000),
    THIRD_CLASS(3, 5, 1_500_000),
    FOURTH_CLASS(4, 4, 50_000),
    FIFTH_CLASS(5, 3, 5_000),
    ZERO_CLASS(0, 0, 0);

    private static final int MINIMUM_MATCH_LOTTO = 3;
    private static final int MATCHING_FIFTH_COUNT = 5;
    private int rank;
    private int countMatching;
    private int profit;

    Ranking(int rank, int countMatching, int profit) {
        this.rank = rank;
        this.countMatching = countMatching;
        this.profit = profit;
    }

    public static Ranking valueOf(int countMatching) {
        return Arrays.stream(Ranking.values())
                .filter(e -> e.countMatching == countMatching)
                .filter(f -> f.rank != 2)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Enum constant was found for matchCount : " + countMatching));
    }

    public static int getProfit(Lottery lottery, WinnerLottery winnerLottery) {
        return winnerLottery.rankLottery(lottery).profit;
    }

    public static Ranking getRank(int count, boolean hasBonusNumber) {
        if (count < MINIMUM_MATCH_LOTTO) {
            return Ranking.ZERO_CLASS;
        }

        if(isMatchingFifth(count) && hasBonusNumber) {
            return Ranking.SECOND_CLASS;
        }

        return Ranking.valueOf(count);
    }

    public static boolean isMatchingFifth(int count) {
        return count == MATCHING_FIFTH_COUNT;
    }

    public void makeRanks(Map<String, Integer> ranks) {
        RankPrintable rankPrintable = makeRanksForPrint(this.rank);
        rankPrintable.makeRanksForPrint(ranks);
    }
}
