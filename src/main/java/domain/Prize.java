package domain;

public enum Prize {
    NONE(0, false, 0),
    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);

    private int toWin;
    private boolean requireBonus;
    private int reward;

    Prize(int toWin, boolean requireBonus, int reward) {
        this.toWin = toWin;
        this.requireBonus = requireBonus;
        this.reward = reward;
    }

    public int getToWin() {
        return toWin;
    }

    public int getReward() {
        return reward;
    }

    public boolean isMatchedPrize(int matched, boolean bonusMatched) {
        return toWin == matched && requireBonus == bonusMatched;
    }

    public static Prize matchPrize(int matched, boolean bonusMatched) {
        for (Prize prize : Prize.values()) {
            if (prize.isMatchedPrize(matched, bonusMatched)) {
                return prize;
            }
        }

        return NONE;
    }
}
