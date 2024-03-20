package lotto.domain;

import java.util.Set;

public class Lotto {

    public static final int FIXED_BALL_AMOUNT = 6;
    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        if (balls.size() != FIXED_BALL_AMOUNT) {
            throw new IllegalArgumentException("로또 공 개수는 " + FIXED_BALL_AMOUNT + "개여야 합니다");
        }
        this.balls = balls;
    }

    public Prize judge(WinningLotto winningLotto) {
        return winningLotto.judge(balls);
    }

    public Set<Ball> balls() {
        return balls;
    }
}
