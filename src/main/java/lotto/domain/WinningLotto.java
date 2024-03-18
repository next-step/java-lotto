package lotto.domain;

import java.util.Set;

public class WinningLotto {

    private final Set<Ball> balls;
    private final Ball bonusBall;

    public WinningLotto(Set<Ball> balls, Ball bonusBall) {
        this.balls = balls;
        this.bonusBall = bonusBall;
    }

    public Set<Ball> balls() {
        return balls;
    }

    public Ball bonusBall() {
        return bonusBall;
    }
}
