package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int money;
    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank rank(int matchCount, boolean matchBonus) {
        if (matchCount == FIRST.matchCount && matchBonus) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount && matchBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount && !matchBonus) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount && matchBonus) {
            return FOURTH;
        }
        if (matchCount == FIFTH.matchCount && matchBonus) {
            return FIFTH;
        }
        return MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }
}
