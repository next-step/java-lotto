package lotto;

public class Money {

  private int value;

  public Money(int value) {
    this.value = value;
  }

  public void add(Money threeMatchWinMoney) {
    this.value += threeMatchWinMoney.value;
  }

  public Money count(long winCount) {
    this.value *= winCount;
    return this;
  }

  public String division(Money winMoney) {
    return String.format("%.2f", (float)this.value / winMoney.value);
  }
}
