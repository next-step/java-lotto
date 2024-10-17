package lotto.domain;

import lotto.enums.Rank;

public class WinnerLotto {
    private final Lotto winnerLotto;
    private final LottoNum winnerBonusNum;

    public WinnerLotto(Lotto lotto, LottoNum lottoNum) {
        this.winnerLotto = lotto;
        this.winnerBonusNum = lottoNum;
    }

    int compareWinningNumber(Lotto lotto) {
        int result = 0;
        for (LottoNum lottoNumber : lotto.getLottoNumbers()) {
            result += addResult(lottoNumber);
        }
        return result;
    }

    private int addResult(LottoNum lottoNumber) {
        if (winnerLotto.isContains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    boolean isMatchBonus(Lotto lotto) {
        return lotto.isContains(winnerBonusNum);
    }

    public Rank match(Lotto lotto) {
        return Rank.getRank(compareWinningNumber(lotto), isMatchBonus(lotto));
    }
}
