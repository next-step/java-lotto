package lotto.domain;

public class WinResult {

  private WinMoney winMoney;
  private long winCount;

  public WinResult(WinMoney winMoney, long winCount) {
    this.winMoney = winMoney;
    this.winCount = winCount;
  }

  public Money reward() {
    return winMoney.totalWinMoney(winCount);
  }
}
