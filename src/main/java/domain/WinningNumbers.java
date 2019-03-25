package domain;

import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusBall;

    public WinningNumbers(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public int calcMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (Integer inputWinningNumber : winningNumbers) {
            if (lotto.isContains(inputWinningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isContainsBonusBall(int matchCount, Lotto lotto) {
        boolean isContainsBonusBall = false;
        if (matchCount == LottoRank.SECOND.getMatchCount()) {
            isContainsBonusBall = lotto.isContains(this.bonusBall);
        }
        return isContainsBonusBall;
    }
}