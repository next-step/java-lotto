package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private int matchCount;
    private int winningMoney;

    Rank(int matchCount, int winningMoney){
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank returnRank(int matchCount){
        Rank[] ranks = values();

        for (Rank rank : ranks){
            if(rank.matchCount == matchCount)
                return rank;
        }

        return Rank.MISS;
    }

    public static int calculateTotalWinningMoney(MatchResult matchResult){
        int total = 0;

        for(Rank rank : values()){
            total += matchResult.matchCountOf(rank) * rank.winningMoney;
        }

        return total;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getWinningMoney(){
        return winningMoney;
    }

}
