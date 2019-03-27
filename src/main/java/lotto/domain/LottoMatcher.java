package lotto.domain;

import lotto.dto.LottoMatchResult;
import lotto.dto.UserLotto;
import lotto.dto.WinningLotto;

public class LottoMatcher {
    private UserLotto userLotto;
    private WinningLotto winningLotto;

    public LottoMatcher(UserLotto userLotto, WinningLotto winningLotto) {
        this.userLotto = userLotto;
        this.winningLotto = winningLotto;
    }

    public LottoMatchResult getLottoMatchResult() {
        return userLotto.getLottoMatchResult(winningLotto);
    }
}
