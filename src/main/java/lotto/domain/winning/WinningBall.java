package lotto.domain.winning;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class WinningBall {
    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningBall(Lotto winningLotto, LottoNumber bonusBall) {
        if (winningLotto.isBonusBall(bonusBall)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 같을 수 없습니다.");
        }

        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public int statCount(Lotto lotto) {
        return lotto.statCount(this.winningLotto);
    }

    public boolean isBonusBall(Lotto lotto) {
        return lotto.isBonusBall(this.bonusBall);
    }
}
