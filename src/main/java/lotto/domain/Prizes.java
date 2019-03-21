package lotto.domain;

public enum Prizes {

  THREE(3, 5 * 1000),
  FOUR(4, 50 * 1000),
  FIVE(5, 1500 * 1000),
  SIX(6, 2 * 1000 * 1000 * 1000),
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
