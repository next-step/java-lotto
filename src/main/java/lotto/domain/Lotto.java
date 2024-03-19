package lotto.domain;

import java.util.Set;

public class Lotto {

    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        if (balls.size() != 6) {
            throw new IllegalArgumentException("로또 공 개수는 6개여야 합니다");
        }
        this.balls = balls;
    }

    public Prize judge(WinningLotto winningLotto) {
        return winningLotto.judge(balls);
    }
}
