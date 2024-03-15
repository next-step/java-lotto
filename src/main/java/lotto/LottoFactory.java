package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoFactory {

    public static Lotto generate() {
        Set<Ball> balls = new HashSet<>();
        while (balls.size() < 6) {
            balls.add(BallFactory.generate());
        }
        return new Lotto(balls);
    }
}
