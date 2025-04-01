package lotto.domain;

public class LottoResult {

  private int winningsNumber;
  private int totalWinningCount;

  LottoResult(int winningsNumber) {
    this.winningsNumber = winningsNumber;
    this.totalWinningCount = 1;
  }

  LottoResult(int winningsNumber, int totalWinningCount) {
    this.winningsNumber = winningsNumber;
    this.totalWinningCount = totalWinningCount;
  }

  public int getWinningsNumber() {
    return winningsNumber;
  }

  public int getTotalWinningCount() {
    return totalWinningCount;
  }

  public void increaseTotalWinningCount() {
    this.totalWinningCount++;
  }

  public long calculateWinning(WinningLotto winningLotto) {
    return
        (long) PRIZES.valueOf(winningsNumber, winningLotto.isContainBonusBall()).getWinningMoney()
            * totalWinningCount;
  }
}
