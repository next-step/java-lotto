package lotto.domain;

public enum Grade {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private int fitCount;
    private int reward;

    Grade(int fitCount, int reward) {
        this.fitCount = fitCount;
        this.reward = reward;
    }

    public int getFitCount() {
        return fitCount;
    }

    public int getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return "Grade{" + this.name() + " " +
            "fitCount=" + fitCount +
            ", reward=" + reward +
            '}' + "\n";
    }
}
