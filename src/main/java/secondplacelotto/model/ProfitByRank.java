package secondplacelotto.model;

public enum ProfitByRank {

    FIRST("1", 2000000000, 6),
    SECOND("2",30000000, 5),
    THIRD("3", 1500000, 5),
    FOURTH("4", 50000, 4),
    FIFTH("5", 5000, 3);

    private final String rank;
    private final int money;
    private final int matchingCount;

    ProfitByRank(String rank, int money, int matchingCount){
        this.rank = rank;
        this.money = money;
        this.matchingCount = matchingCount;
    }

    public static MatchingNumbers matchByRank(MatchingNumbers matchingNumbers, int matchingCount, boolean isMatchBonus) {

        for (ProfitByRank profitByRank : values()) {
            matchThirdRank(matchingNumbers, matchingCount, isMatchBonus);
            matchRank(profitByRank, matchingCount, matchingNumbers);
        }

        return matchingNumbers;
    }

    private static MatchingNumbers matchThirdRank(MatchingNumbers matchingNumbers, int matchingCount, boolean isMatchBonus) {
        if (matchingCount == 5 && !isMatchBonus) {
            matchingNumbers.addMatchingCount(SECOND.rank);
        }

        return matchingNumbers;
    }

    private static MatchingNumbers matchRank(ProfitByRank profitByRank, int matchingCount, MatchingNumbers matchingNumbers) {
        if (profitByRank.matchingCount == matchingCount ) {
            matchingNumbers.addMatchingCount(profitByRank.rank);
        }

        return matchingNumbers;
    }

    public static int getMatchProfit(String rank, int matchingCount, int profit) {
        for (ProfitByRank profitByRank : values()) {
            profit += matchingProfit(profitByRank, rank) * matchingCount;
        }

        return profit;
    }

    private static int matchingProfit(ProfitByRank profitByRank, String rank) {
        if (profitByRank.rank.equals(rank)) {
            return profitByRank.money;
        }

        return 0;
    }
}
