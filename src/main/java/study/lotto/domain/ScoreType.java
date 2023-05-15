package study.lotto.domain;

import java.util.Arrays;

public enum ScoreType {
    SIX(1, 6, 2_000_000_000, true, false),
    BONUS(2, 5, 30_000_000, true, true),
    FIVE(3, 5, 1_500_000, true, false),
    FOUR(4, 4, 50_000, true, false),
    THREE(5, 3, 5_000, true, false),
    TWO(6, 2, 0, false, false),
    ONE(7, 1, 0, false, false),
    ZERO(8, 0, 0, false, false),
    ;

    private final int rank;
    private final int score;
    private final int reward;
    private final boolean display;

    private final boolean bonus;


    ScoreType(int rank, int score, int reward, boolean display, boolean bonus) {
        this.rank = rank;
        this.score = score;
        this.reward = reward;
        this.display = display;
        this.bonus = bonus;
    }

    public static ScoreType of(Integer score) {
        return Arrays.stream(values())
                .filter(type -> type.score == score)
                .filter(type -> !type.bonus)
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(ScoreType.class, score.toString()));
    }

    public static ScoreType ofBonus() {
        return ScoreType.BONUS;
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

    public int getRank() {
        return rank;
    }

    public String getStatus() {
        if (this == BONUS) {
            return getScore() + "개 일치, 보너스 볼 일치 (" + getReward() + ")";
        }
        return getScore() + "개 일치 (" + getReward() + ")";
    }
}
