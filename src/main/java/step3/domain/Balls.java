package step3.domain;

import static step3.domain.Lottery.WINNING_STREAK;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Integer> balls = new ArrayList<>();

    public Balls(List<Integer> balls) {
        this.balls.addAll(balls);
    }

    public static Balls of(List<Integer> balls) {
        validateNumbers(balls);
        return new Balls(balls);
    }

    public List<Integer> getBalls() {
        return balls;
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (WINNING_STREAK != numbers.size()) {
            throw new IllegalArgumentException("잘 못 생성된 로또 - " + numbers.size());
        }
    }
}
