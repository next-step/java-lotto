package lotto.domain;

public class Money {

  private final int amount;

  public Money(int amount) {
    this.amount = amount;
  }

  public int buy(int productAmount) {

    if (this.amount < productAmount) {
      throw new IllegalArgumentException();
    }

    return this.amount / productAmount;
  }
}
