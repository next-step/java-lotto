package lotto.core.round;

import lombok.Getter;
import lotto.core.Ball;
import lotto.core.Machine;
import lotto.core.SixBall;
import lotto.core.exception.LottoRuleException;

@Getter
public class Round {
    private static final int DEFAULT_ROUND = 0;

    private final int round;
    private final SixBall sixBall;
    private final Ball bonusBall;

    public Round(WinSixBall sixBall, int bonus) {
        this(DEFAULT_ROUND, sixBall, Machine.draw(bonus));
    }

    public Round(WinSixBall sixBall, Ball bonusBall) {
        this(DEFAULT_ROUND, sixBall, bonusBall);
    }

    public Round(int round, WinSixBall sixBall, int bonus) {
        this(round, sixBall, Machine.draw(bonus));
    }

    public Round(int round, WinSixBall sixBall, Ball bonusBall) {
        this.round = round;
        this.sixBall = sixBall.toSixBall();
        this.bonusBall = bonusBall;

        if (validation()) {
            throw new LottoRuleException("보너스 볼이 당첨 번호에 포함되어 있습니다.");
        }
    }

    public Rank grade(final SixBall sixBall) {
        return Rank.valueOf(matchCount(sixBall), isMatchBonus(sixBall));
    }

    private int matchCount(final SixBall expectedSixBall) {
        return (int) sixBall.stream()
                .filter(expectedSixBall::contains)
                .count();
    }

    private boolean isMatchBonus(SixBall sixBall) {
        return sixBall.contains(bonusBall);
    }

    private boolean validation() {
        return sixBall.contains(bonusBall);
    }

    @Override
    public String toString() {
        return String.format("%d회차 당첨번호 : %s", round, sixBall);
    }
}
