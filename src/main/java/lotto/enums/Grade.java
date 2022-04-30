package lotto.enums;

public enum Grade {

  FIRST(6, 2_000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FOURTH(3, 5_000);

  private final int expectNumber;
  private final int awardPrice;

  Grade(int expectNumber, int awardPrice) {
    this.expectNumber = expectNumber;
    this.awardPrice = awardPrice;
  }

  public int winningAmount(int count) {
    return this.awardPrice * count;
  }

  public int getExpectNumber() {
    return expectNumber;
  }

  public long getAwardPrice() {
    return awardPrice;
  }

}
