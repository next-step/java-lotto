package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;

public class LottoRaffle {

    private final WinningLotto winningLotto;
    private MatchResult matchResult;

    public LottoRaffle(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        matchResult = MatchResult.init();
    }

    public void compareLotto(Lotto lotto) {
        final int matchCount = calculateMatchCount(lotto);
        final boolean isBonusNumber = calculateBonusNumber(lotto);

        final LottoResult lottoResult = LottoResult.findLottoResult(matchCount, isBonusNumber);
        matchResult = matchResult.combine(lottoResult);
    }

    private boolean calculateBonusNumber(Lotto lotto) {
        return lotto.hasNumber(winningLotto.getBonusNumber());
    }

    private Integer calculateMatchCount(Lotto lotto) {
        return lotto.getMatchCount(winningLotto);
    }

    public MatchResult getResults() {
        return matchResult;
    }
}
