package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        if (balls.size() != 6) {
            throw new IllegalArgumentException("로또 공 개수는 6개여야 합니다");
        }
        this.balls = balls;
    }

    public Set<Ball> balls() {
        return balls;
    }

    public Prize judge(WinningLotto lotto) {
        Set<Ball> copiedBalls = new HashSet<>(balls);
        copiedBalls.retainAll(lotto.balls());
        int matchingCount = copiedBalls.size();
        boolean matchedBonus = this.balls.contains(lotto.bonusBall());
        return Prize.from(matchingCount, matchedBonus);
    }
}
