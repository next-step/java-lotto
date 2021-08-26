package step2.model.lottostore;

public enum WinnerMoney {
  FIRST_WINNER_MONEY(1, 6, false, 2000000000),
  SECOND_WINNER_MONEY(2, 5, true, 30000000),
  THIRD_WINNER_MONEY(3, 5, false, 1500000),
  FOURTH_WINNER_MONEY(4, 4, false, 50000),
  FIFTH_WINNER_MONEY(5, 3, false, 5000);

  int winRank;
  int matchNumberCount;
  boolean matchBonusNumber;
  int prizeMoney;

  WinnerMoney(int winRank, int matchNumberCount, boolean matchBonusNumber, int prizeMoney) {
    this.winRank = winRank;
    this.matchNumberCount = matchNumberCount;
    this.matchBonusNumber = matchBonusNumber;
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

  public boolean hasMatchBonusNumber() {
    return matchBonusNumber;
  }
}
