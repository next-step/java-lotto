package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private final Lotto lotto;
    private final Ball bonusBall;

    public WinningLotto(final Lotto lotto, final Ball bonusBall) {
        validate(lotto, bonusBall);
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validate(final Lotto lotto, final Ball bonusBall) {
        if (lotto.containsBall(bonusBall)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼이 중복됩니다.");
        }
    }

    public int matchCount(final List<Ball> balls) {
        Set<Ball> userBalls = new HashSet<>(balls);

        userBalls.retainAll(this.lotto.getBalls());

        return userBalls.size();
    }

    public boolean isMatchBonusBall(final List<Ball> balls) {
        return balls.contains(this.bonusBall);
    }
}
