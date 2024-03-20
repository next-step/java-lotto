package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoFactory {

    private LottoFactory() {

    }

    public static Lotto generate() {
        Set<Ball> balls = new HashSet<>();
        while (balls.size() < Lotto.FIXED_BALL_AMOUNT) {
            balls.add(BallFactory.generate());
        }
        return new Lotto(balls);
    }
}
