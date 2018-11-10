package domain;

public enum Prize {
    NONE(0, 0),
    FOURTH_PRIZE(3, 5000),
    THIRD_PRIZE(4, 50000),
    SECOND_PRIZE(5, 1500000),
    FIRST_PRIZE(6, 2000000000);

    private int forWin;
    private int reward;

    Prize(int forWin, int reward) {
        this.forWin = forWin;
        this.reward = reward;
    }

    public int getForWin() {
        return forWin;
    }

    public int getReward() {
        return reward;
    }

    public boolean isMatchedPrize(int matched) {
        return forWin == matched;
    }

    public static Prize matchPrize(int matched) {
        for (Prize prize : Prize.values()) {
            if (prize.isMatchedPrize(matched)) {
                return prize;
            }
        }

        return NONE;
    }
}
