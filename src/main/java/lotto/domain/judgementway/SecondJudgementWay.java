package lotto.domain.judgementway;

import lotto.domain.WinningResult;

public class SecondJudgementWay implements JudgementWay {
    private static final SecondJudgementWay secondJudgementWay = new SecondJudgementWay();

    private SecondJudgementWay() {
    }

    public static SecondJudgementWay instance() {
        return secondJudgementWay;
    }
    @Override
    public Boolean apply(Integer correctCount, WinningResult winningResult) {
        return winningResult.hasSameCorrectCount(correctCount) && !winningResult.isBonus();
    }
}
