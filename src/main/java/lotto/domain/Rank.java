package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 3_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int matchCount;
    private int winningMoney;

    Rank(int matchCount, int winningMoney){
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank returnRank(int matchCount){
        Rank[] ranks = values();

        return Arrays.stream(ranks)
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public static int calculateTotalWinningMoney(MatchResult matchResult){
        int total = 0;

        for(Rank rank : values()){
            total += matchResult.matchCountOf(rank) * rank.winningMoney;
        }

        return total;
    }

    public static Rank rankOf(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return MISS;
        }

        Rank rank = returnRank(matchCount);
        if (SECOND.matchCount == matchCount) {
            return matchBonus ? SECOND : THIRD;
        }

        return rank;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getWinningMoney(){
        return winningMoney;
    }

}
