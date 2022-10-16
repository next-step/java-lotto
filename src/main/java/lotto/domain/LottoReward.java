package lotto.domain;

public enum LottoReward {

    FIRST(2_000_000_000, 6), SECOND(30_000_000, 5), THIRD(1_500_000, 5),
    FOURTH(50_000, 4), FIFTH(5_000, 3), MISS(0, 4);

    private final int reward;
    private final int count;

    LottoReward(final int reward, final int count) {
        this.reward = reward;
        this.count = count;
    }

    public static int reward(final int rank) {
        return values()[rank - 1].reward;
    }

    public static int count(final int rank) {
        return LottoReward.values()[rank - 1].count;
    }
}
