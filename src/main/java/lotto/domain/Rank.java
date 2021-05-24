package lotto.domain;

public enum Rank {
    nothing(0,0),
    threeNumbersMatch(3,5_000),
    fourNumbersMatch(4,50_000),
    fiveNumbersMatch(5,1_500_000),
    sixNumbersMatch(6,2_000_000_000)
    ;

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static int prize(Rank targetRank) {
        for (Rank rank : values()) {
            if( rank  == targetRank) {
                return rank.prize;
            }
        }
        return 0;
    }

    public static Rank of(int matchCount) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return Rank.nothing;
    }


}
