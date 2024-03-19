package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {

    private final Set<Ball> balls;
    private final Ball bonusBall;

    public WinningLotto(Set<Ball> balls, Ball bonusBall) {
        this.balls = balls;
        this.bonusBall = bonusBall;
    }

    public Prize judge(Set<Ball> balls) {
        Set<Ball> copiedBalls = new HashSet<>(balls);
        copiedBalls.retainAll(this.balls);
        int matchingCount = copiedBalls.size();
        boolean matchedBonus = this.balls.contains(this.bonusBall);
        return Prize.from(matchingCount, matchedBonus);
    }
}
