package lotto.domain.judgementway;

import lotto.domain.WinningResult;

public class BonusJudgementWay implements JudgementWay {
    private static final BonusJudgementWay basicJudgementWay = new BonusJudgementWay();

    private BonusJudgementWay() {
    }

    public static BonusJudgementWay instance() {
        return basicJudgementWay;
    }

    @Override
    public Boolean apply(Integer correctCount, WinningResult winningResult) {
        return winningResult.hasSameCorrectCount(correctCount) && winningResult.isBonus();
    }
}
