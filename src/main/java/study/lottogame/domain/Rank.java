package study.lottogame.domain;

public enum Rank {
  MISS(0, 0),
  FOURTH(3, 5_000),
  THIRD(4, 50_000),
  SECOND(5, 1_500_000),
  FIRST(6, 2_000_000_000);

  private int countOfMatch;
  private int winningMoney;

  private Rank(int countOfMatch, int winningMoney) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public static Rank valueOf(int countOfMatch) {
    for (Rank rank : Rank.values()) {
      if (rank.getCountOfMatch() == countOfMatch) {
        return rank;
      }
    }
    return Rank.MISS;
  }
}
