package lotto;

import java.util.List;

public class LottoResult {
    private MatchCount matchCount;

    private BonusMatch bonusMatch;

    public LottoResult() {
        this.matchCount = new MatchCount(0);
    }

    public MatchCount getMatchCount() {
        return this.matchCount;
    }

    public BonusMatch getBonusMatch() {
        return this.bonusMatch;
    }

    public void calculateMatchCount(WinningLotto winningLotto, List<LottoNumber> lottoNumbers) {
        this.matchCount.calculateWinningMatchCount(winningLotto, lottoNumbers);
        this.bonusMatch = new BonusMatch(winningLotto.checkBonusMatch(lottoNumbers)); //todo
    }

    public int getAmountForWinningLotto() {
        if (!LottoRank.isWinning(this.matchCount)) {
            return 0;
        }
        return LottoRank.determineAmountByMatchCount(this.matchCount, this.bonusMatch);
    }
}
