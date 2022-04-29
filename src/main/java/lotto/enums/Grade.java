package lotto.enums;

public enum Grade {

  THREE(3, 5_000),
  FOUR(4, 50_000),
  FIVE(5, 1_500_000),
  SIX(6, 2_000_000_000);

  private static final Integer GUESSED = 1;
  private static final Integer WRONG = 0;
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

  public int getAwardPrice() {
    return awardPrice;
  }

}
