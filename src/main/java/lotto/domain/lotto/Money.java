package lotto.domain.lotto;

public class Money {
  private final int amount;

  public Money(int amount) {
    validate(amount);
    this.amount = amount;
  }

  private void validate(int amount){
    if(amount < 0) throw new IllegalArgumentException("금액은 0이상이어야 합니다");
  }

  public float divideBy(Money divisor) {
    if (divisor.amount <= 0) {
      throw new IllegalArgumentException("몫은 0보다 커야 합니다");
    }
    return (float) this.amount / divisor.amount;
  }
}
