package lotto.domain;

public enum Rank {
    FIRST(6, 200_000_000),
    SECOND(5, 15_000_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NO_MATCH(0, 0);

    private int matchCount;
    private int money;
    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank rank(int matchCount) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        return NO_MATCH;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }
}
