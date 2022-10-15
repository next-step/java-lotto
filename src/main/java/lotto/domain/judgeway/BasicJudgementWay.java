package lotto.domain.judgeway;

import lotto.domain.WinningResult;

public class BasicJudgementWay implements JudgementWay {

    private static final BasicJudgementWay basicJudgementWay = new BasicJudgementWay();

    private BasicJudgementWay() {
    }

    public static BasicJudgementWay instance() {
        return basicJudgementWay;
    }

    @Override
    public Boolean apply(Integer correctCount, WinningResult winningResult) {
        return winningResult.hasSameCorrectCount(correctCount);
    }
}
