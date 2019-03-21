package lotto.domain;

public enum Prizes {

  THREE(3, 5000),
  FOUR(4, 50000),
  FIVE(5, 1500000),
  SIX(6, 2000000000),
  ;

  private int matchCount;
  private long money;

  Prizes(int matchCount, long money) {
    this.money = money;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public Money getMoney() {
    return new Money(this.money);
  }

}
