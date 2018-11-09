package domain;

public enum Prize {
    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 1500000),
    THIRD_PRIZE(4, 50000),
    FOURTH_PRIZE(3, 5000),
    NONE(0, 0);

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

    public static Prize matchPrize(int matched) {
        if (matched == 6) {
            return FIRST_PRIZE;
        } else if (matched == 5) {
            return SECOND_PRIZE;
        } else if (matched == 4) {
            return THIRD_PRIZE;
        } else if (matched == 3) {
            return FOURTH_PRIZE;
        }

        return NONE;
    }
}
