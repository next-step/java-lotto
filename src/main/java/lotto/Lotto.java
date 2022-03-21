package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final Collection<LottoBall> balls = new HashSet<>();

    public Lotto(Collection<Integer> numbers) {
        this.addBalls(numbers);
        this.validate();
    }

    private void addBalls(Collection<Integer> numbers) {
        numbers.stream().forEach(number -> {
            LottoBall ball = new LottoBall(number);
            balls.add(ball);
        });
    }

    private void validate() {
        if(this.balls.size() != 6) {
            throw new IllegalArgumentException("로또는 중복된 숫자를 가지거나, 6개의 숫자만을 가져야 합니다.");
        }
    }

    public Collection<LottoBall> getBalls() {
        return this.balls;
    }
}
