package lotto.domain;

public enum Prizes {

  THREE(3, 5_000),
  FOUR(4, 50_000),
  FIVE(5, 1500_000),
  SIX(6, 2_000_000_000),
  ;

  private int matchCount;
  private long money;

  Prizes(int matchCount, long money) {
    this.matchCount = matchCount;
    this.money = money;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public Money getMoney() {
    return new Money(this.money);
  }

}
