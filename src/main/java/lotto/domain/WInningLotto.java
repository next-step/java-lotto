package lotto.domain;

import java.util.List;

public class WInningLotto {
    private Lotto lotto = null;
    private LottoBall bonusBall = null;

    public WInningLotto(Lotto lotto, LottoBall bonusBall) {
        if (bonusBall.isIncludeIn(lotto.getNumbers())) {
            throw new IllegalArgumentException("로또 당첨번호와 보너스 번호는 같을 수 없습니다.");
        }
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public LottoBall getBonusBall() {
        return this.bonusBall;
    }

    public int howManyMatchBall(Lotto otherLotto) {
        return this.lotto.howManyMatchBall(otherLotto);
    }

    public boolean hasBonusBall(Lotto otherLotto) {
        return otherLotto.hasBall(bonusBall);
    }
}
