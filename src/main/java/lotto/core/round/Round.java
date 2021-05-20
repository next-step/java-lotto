package lotto.core.round;

import lotto.core.Ball;
import lotto.core.Machine;
import lotto.core.SixBall;
import java.util.stream.Stream;

public class Round {
    private static final int DEFAULT_ROUND = 0;

    private final int round;
    private final SixBall sixBall;
    private final Ball bonusBall;

    public Round(SixBall sixBall, int bonus) {
        this(DEFAULT_ROUND, sixBall, bonus);
    }

    public Round(int round, SixBall sixBall, int bonus) {
        this.round = round;
        this.sixBall = sixBall;
        this.bonusBall = Machine.draw(bonus);
    }

    public Stream<Ball> stream() {
        return sixBall.stream();
    }

    public Ball getBonusBall() {
        return bonusBall;
    }

    @Override
    public String toString() {
        return String.format("%d회차 당첨번호 : %s", round, sixBall);
    }
}
