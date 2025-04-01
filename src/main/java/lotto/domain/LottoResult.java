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

  public void increaseTotalWinningCount() {
    this.totalWinningCount++;
  }

  public long calculateWinning(WinningLotto winningLotto) {
    return PRIZES.valueOf(winningsNumber, winningLotto.isContainBonusBall())
        .calculateWinning(totalWinningCount);
  }

  public int matchesWinningCount(int winningNumber) {
    if(this.winningsNumber == winningNumber) return totalWinningCount;
    return -1;
  }

  public boolean matchesWinningNumber(int count) {
    return winningsNumber == count;
  }
}
