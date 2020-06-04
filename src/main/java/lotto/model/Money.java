package lotto.model;

public class Money {

  private long value;

  public Money(long value) {
    if (value < 0) {
      throw new IllegalArgumentException("돈은 음수일 수 없습니다.");
    }

    this.value = value;
  }

  public long getValue() {
    return value;
  }

  public void add(Money money) {
    this.value += money.getValue();
  }
}
