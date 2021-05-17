package lotto;

public enum Rank {
    MISS_MATCH(0,false,0),
    MATCH_3(3,false, 5000),
    MATCH_4(4,false, 50000),
    MATCH_5(5,false, 1500000),
    MATCH_5_BONUS(5,true,30000000),
    MATCH_6(6,false, 2000000000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount,boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus=matchBonus;
        this.prize = prize;

    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
