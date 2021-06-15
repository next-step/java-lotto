package lotto.domain;

public enum Rank {
    MATCH_3(3, false, 5_000),
    MATCH_4(4, false, 50_000),
    MATCH_5(5, false, 1_500_000),
    MATCH_5_BONUS(5, true, 30_000_000),
    MATCH_6(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;

    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }
}
