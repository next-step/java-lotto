package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    protected final List<LottoBall> balls;

    public Lotto(Integer... numbers) {
        this(Arrays.stream(numbers)
                .map(LottoBall::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoBall> balls) {
        if (balls.size() != 6) {
            throw new IllegalArgumentException("로또는 6개 숫자여야 합니다.");
        }
        this.balls = balls;
    }

    public long getMatchingBallCountFrom(Lotto lotto) {
        return lotto.balls
                .stream()
                .mapToLong(this::traverseCompareTo)
                .sum();
    }

    public long traverseCompareTo(LottoBall comparingBall) {
        return this.balls
                .stream()
                .filter(ball -> ball.equals(comparingBall))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(balls, lotto.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
