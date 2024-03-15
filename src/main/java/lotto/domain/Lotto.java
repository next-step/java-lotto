package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        this.balls = balls;
    }

    public Set<Ball> balls() {
        return balls;
    }

    public int countMatchingBalls(Lotto lotto) {
        Set<Ball> copiedBalls = new HashSet<>(balls);
        copiedBalls.retainAll(lotto.balls);
        return copiedBalls.size();
    }
}
