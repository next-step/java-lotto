package lotto.domain;

public class TestWinStats extends WinStats {

  private Money totalWinMoney;

  public TestWinStats() {

  }

  public void setTotalWinMoney(Money totalWinMoney) {
    this.totalWinMoney = totalWinMoney;
  }

  @Override
  public Money getTotalWinMoney() {
    return this.totalWinMoney;
  }
}
