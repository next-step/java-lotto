package lotto.core.round;

import lotto.core.Ball;
import lotto.core.Machine;
import lotto.core.SixBall;
import lotto.core.exception.LottoRuleException;
import java.util.stream.Stream;

public class Round {
    private static final int DEFAULT_ROUND = 0;

    private final int round;
    private final SixBall sixBall;
    private final Ball bonusBall;

    public Round(SixBall sixBall, int bonus) {
        this(DEFAULT_ROUND, sixBall, Machine.draw(bonus));
    }

    public Round(SixBall sixBall, Ball bonusBall) {
        this(DEFAULT_ROUND, sixBall, bonusBall);
    }

    public Round(int round, SixBall sixBall, Ball bonusBall) {
        this.round = round;
        this.sixBall = sixBall;
        this.bonusBall = bonusBall;

        if (validation()) {
            throw new LottoRuleException("보너스 볼이 당첨 번호에 포함되어 있습니다.");
        }
    }

    public Stream<Ball> stream() {
        return sixBall.stream();
    }

    public Ball getBonusBall() {
        return bonusBall;
    }

    private boolean validation() {
        return sixBall.contains(bonusBall);
    }

    @Override
    public String toString() {
        return String.format("%d회차 당첨번호 : %s", round, sixBall);
    }
}
