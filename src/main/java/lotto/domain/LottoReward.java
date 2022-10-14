package lotto.domain;

public enum LottoReward {

    FIRST(2_000_000_000, 1), SECOND(30_000_000, 2), THIRD(1_500_000, 3), FOURTH(50_000, 4), FIFTH(5_000, 5);

    private int reward;
    private int rank;

    LottoReward(int reward, int rank) {
        this.reward = reward;
        this.rank = rank;
    }

    public int reward() {
        return reward;
    }

    public static int reward(int rank) {
        return values()[rank - 1].reward();
    }
}
