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

    //todo
    private int calculateWinningMatchCount(WinningLotto winningLotto, List<LottoNumber> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            this.matchCount += checkWinningMatchNumber(winningLotto, lottoNumbers.get(i));
        }
        return this.matchCount;
    }

    private int checkWinningMatchNumber(WinningLotto winningLotto, LottoNumber number) {
        if (winningLotto.hasLottoNumber(number)) {
            return 1;
        }
        return 0;
    }

    public int getAmountForWinningLotto() {
        if (!LottoRank.isWinning(this.matchCount)) {
            return 0;
        }
        return LottoRank.determineAmountByMatchCount(this.matchCount, this.isBonusMatch);
    }
}
