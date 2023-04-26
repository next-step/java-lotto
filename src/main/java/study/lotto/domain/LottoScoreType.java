package study.lotto.domain;

import java.util.Arrays;

public enum LottoScoreType {
    SIX(6, 2000000000, true),
    FIVE(5, 1500000, true),
    FOUR(4, 50000, true),
    THREE(3, 5000, true),
    TWO(2, 0, false),
    ONE(1, 0, false),
    ZERO(0, 0, false),
    ;

    private final Integer score;
    private final Integer reward;
    private final Boolean display;



    LottoScoreType(Integer score, Integer reward, Boolean display) {
        this.score = score;
        this.reward = reward;
        this.display = display;
    }

    public static LottoScoreType of(Integer score) {
        return Arrays.stream(values())
                .filter(lottoScore -> lottoScore.score.equals(score))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(LottoScoreType.class, score.toString()));
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
