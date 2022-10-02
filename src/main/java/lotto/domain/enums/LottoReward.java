package lotto.domain.enums;

/**
 * 로또 상금
 */
public enum LottoReward {

    FIRST(2_000_000_000),
    SECOND(1_500_000),
    THIRD(50_000),
    FOURTH(5_000)
    ;

    private final int reward;

    LottoReward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }
}
