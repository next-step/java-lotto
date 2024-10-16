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

    public int calculateMatchCount(List<Integer> winningNumbers, List<Integer> lottoNumbers, int bonusNumber) {
        calculateWinningMatchCount(winningNumbers, lottoNumbers);
        checkBonusMatch(lottoNumbers, bonusNumber);
        return matchCount;
    }

    private int calculateWinningMatchCount(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            this.matchCount += checkWinningMatchNumber(winningNumbers, lottoNumbers.get(i));
        }
        return this.matchCount;
    }

    private int checkWinningMatchNumber(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private void checkBonusMatch(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            this.isBonusMatch = true;
        }
    }

    public int getAmountForWinningLotto() {
        if (!LottoRank.isWinning(this.matchCount)) {
            return 0;
        }
        return LottoRank.determineAmountByMatchCount(this.matchCount, this.isBonusMatch);
    }
}
