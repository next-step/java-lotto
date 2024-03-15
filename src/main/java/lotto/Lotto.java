package lotto;

import java.util.Set;

public class Lotto {

    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        this.balls = balls;
    }

    public Set<Ball> balls() {
        return balls;
    }
}
