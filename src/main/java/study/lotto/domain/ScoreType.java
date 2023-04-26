package study.lotto.domain;

import java.util.Arrays;

public enum ScoreType {
    SIX(6, 2_000_000_000, true),
    FIVE(5, 1_500_000, true),
    FOUR(4, 50_000, true),
    THREE(3, 5_000, true),
    TWO(2, 0, false),
    ONE(1, 0, false),
    ZERO(0, 0, false),
    ;

    private final Integer score;
    private final Integer reward;
    private final Boolean display;



    ScoreType(Integer score, Integer reward, Boolean display) {
        this.score = score;
        this.reward = reward;
        this.display = display;
    }

    public static ScoreType of(Integer score) {
        return Arrays.stream(values())
                .filter(lottoScore -> lottoScore.score.equals(score))
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
