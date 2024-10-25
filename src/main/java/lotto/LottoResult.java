package lotto;

import java.util.List;

public class LottoResult {
    private int matchCount;
    private boolean isBonusMatch = false;

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getIsBonusMatch() {
        return this.isBonusMatch;
    }

    public int calculateMatchCount(WinningLotto winningLotto, List<LottoNumber> lottoNumbers) {
        calculateWinningMatchCount(winningLotto, lottoNumbers);
        this.isBonusMatch = winningLotto.checkBonusMatch(lottoNumbers);
        return matchCount;
    }

    private void calculateWinningMatchCount(WinningLotto winningLotto, List<LottoNumber> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            this.matchCount += winningLotto.hasLottoNumber(lottoNumbers.get(i)) ? 1 : 0;
        }
    }

    public int getAmountForWinningLotto() {
        if (!LottoRank.isWinning(this.matchCount)) {
            return 0;
        }
        return LottoRank.determineAmountByMatchCount(this.matchCount, this.isBonusMatch);
    }
}
