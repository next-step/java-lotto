package study.lotto.domain;

import java.util.Arrays;

public enum ScoreType {
    SIX(6, 2_000_000_000, true, false),
    BONUS(5, 30_000_000, true, true),
    FIVE(5, 1_500_000, true, false),
    FOUR(4, 50_000, true, false),
    THREE(3, 5_000, true, false),
    TWO(2, 0, false, false),
    ONE(1, 0, false, false),
    ZERO(0, 0, false, false),
    ;

    private final int score;
    private final int reward;
    private final boolean display;

    private final boolean bonus;


    ScoreType(int score, int reward, boolean display, boolean bonus) {
        this.score = score;
        this.reward = reward;
        this.display = display;
        this.bonus = bonus;
    }

    public static ScoreType of(Integer score, boolean isBonus) {
        if (isBonus) {
            return BONUS;
        }

        return Arrays.stream(values())
                .filter(type -> type.score == score)
                .filter(type -> !type.bonus)
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(ScoreType.class, score.toString()));
    }

    public boolean canDisplay() {
        return this.display;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getReward() {
        return reward;
    }
}
