package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.Lotto;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoNumber;

public class LottoWinningNumber {
    private Lotto winningLotto;
    private LottoNumber bonus;

    public LottoWinningNumber(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonus = new LottoNumber(bonusNumber);
    }

    public LottoAward getAwardResult(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningLotto);
        return LottoAward.valueOf(matchCount, lotto.contain(bonus));
    }
}
