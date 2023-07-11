package lotto.domain;

import java.util.List;

public class Lotto {

    private List<Ball> balls;

    public Lotto(final List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    private void validate(final List<Ball> balls) {
        if (balls.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
