package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;

public class LottoRaffle {

    private final WinningLotto winningLotto;

    public LottoRaffle(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public MatchResult compareLottos(Lottos lottos) {
        MatchResult matchResult = MatchResult.init();
        for (Lotto lotto : lottos.getLottos()) {
            final int matchCount = calculateMatchCount(lotto);
            final boolean isBonusNumber = calculateBonusNumber(lotto);
            matchResult = matchResult.combine(matchCount, isBonusNumber);
        }
        return matchResult;
    }

    private Integer calculateMatchCount(Lotto lotto) {
        return lotto.getMatchCount(winningLotto);
    }

    private boolean calculateBonusNumber(Lotto lotto) {
        return lotto.hasNumber(winningLotto.getBonusNumber());
    }
}
