package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final Set<Ball> balls;

    public Lotto(List<Integer> lottoNumbers) {
        this(
            lottoNumbers.stream()
                .map(Ball::new)
                .collect(Collectors.toUnmodifiableSet())
        );
    }

    public Lotto(Set<Ball> balls) {
        this.balls = balls;
    }

    public Set<Ball> balls() {
        return balls;
    }

    public Prize judge(Lotto lotto) {
        Set<Ball> copiedBalls = new HashSet<>(balls);
        copiedBalls.retainAll(lotto.balls);
        int matchingCount = copiedBalls.size();
        return Prize.from(matchingCount);
    }
}
