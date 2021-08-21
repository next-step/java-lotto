package step2.model;

public enum WinnerMoney {
  FIRST_WINNER_MONEY(1, 6, 2000000000),
  SECOND_WINNER_MONEY(2, 5, 1500000),
  THIRD_WINNER_MONEY(3, 4, 50000),
  FOURTH_WINNER_MONEY(4, 3, 5000);

  int winRank;
  int matchNumberCount;
  int prizeMoney;

  WinnerMoney(int winRank, int matchNumberCount, int prizeMoney) {
    this.winRank = winRank;
    this.matchNumberCount = matchNumberCount;
    this.prizeMoney = prizeMoney;
  }

  public int getWinRank() {
    return winRank;
  }

  public int getMatchNumberCount() {
    return matchNumberCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
}
