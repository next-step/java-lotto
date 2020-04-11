package lotto.domain;

public enum Prize {
    MISS(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 150_0000),
    SECOND(5, 30_000_000),
    FIRST(6, 2000_000_000);

    private int match;
    private int amount;

    Prize(int match, int amount) {
        this.match = match;
        this.amount = amount;
    }

    public int getMatch() {
        return match;
    }

    public int getAmount() {
        return amount;
    }

    static Prize of(int match, boolean bonusNumber) {
        if (isSecondPrize(match, bonusNumber)) {
            return SECOND;
        }

        for (Prize prize : values()) {
            if (prize.isMatchCount(match) && prize != SECOND) {
                return prize;
            }
        }

        return MISS;
    }

    private static boolean isSecondPrize(int match, boolean bonusNumber) {
        return SECOND.isMatchCount(match) && bonusNumber;
    }

    private boolean isMatchCount(int match) {
        return this.match == match;
    }

}
