package lotto;

import java.util.List;

public class LottoResult {
    private MatchCount matchCount;
    private boolean isBonusMatch = false;

    public LottoResult() {
        this.matchCount = new MatchCount(0);
    }

    public int getMatchCount() {
        return this.matchCount.getMatchCount();
    }

    public boolean getIsBonusMatch() {
        return this.isBonusMatch;
    }

    public void calculateMatchCount(WinningLotto winningLotto, List<LottoNumber> lottoNumbers) {
        this.matchCount.calculateWinningMatchCount(winningLotto, lottoNumbers);
        this.isBonusMatch = winningLotto.checkBonusMatch(lottoNumbers);
    }

    public int getAmountForWinningLotto() {
        if (!LottoRank.isWinning(this.matchCount)) {
            return 0;
        }
        return LottoRank.determineAmountByMatchCount(this.matchCount, this.isBonusMatch);
    }
}
