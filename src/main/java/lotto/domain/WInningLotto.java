package lotto.domain;

import java.util.List;

public class WInningLotto extends Lotto {
    private LottoBall bonusBall = null;

    public WInningLotto(List<LottoBall> winningBalls, LottoBall bonusBall) {
        super(winningBalls);
        if (bonusBall.isIncludeIn(winningBalls)) {
            throw new IllegalArgumentException("로또 당첨번호와 보너스 번호는 같을 수 없습니다.");
        }
        this.bonusBall = bonusBall;
    }

    public LottoBall getBonusBall() {
        return bonusBall;
    }

    public int howManyMatchBall(Lotto otherLotto) {
        int count = 0;
        for (LottoBall ball : this.balls) {
            count += isInculdeIn(ball, otherLotto);
        }
        return count;
    }

    public boolean hasBonusBall(Lotto otherLotto) {
        return bonusBall.isIncludeIn(otherLotto.getNumbers());
    }

    private int isInculdeIn(LottoBall ball, Lotto lotto) {
        if (ball.isIncludeIn(lotto.getNumbers())) {
            return 1;
        }
        return 0;
    }
}
