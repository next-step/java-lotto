package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int matchCount;
    private int winningMoney;

    Rank(int matchCount, int winningMoney){
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static int winningMoneyOf(int matchCount){
        Rank[] ranks = values();

        for (Rank rank : ranks){
            if(rank.matchCount == matchCount)
                return rank.winningMoney;
        }

        throw new IllegalArgumentException("일치 갯수가 잘못되었습니다.");
    }

    public static Rank returnRank(int matchCount){
        Rank[] ranks = values();

        for (Rank rank : ranks){
            if(rank.matchCount == matchCount)
                return rank;
        }

        return Rank.MISS;
    }
}
