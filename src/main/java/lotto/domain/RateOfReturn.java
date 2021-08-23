package lotto.domain;

public class RateOfReturn {

  private final double rate;

  public RateOfReturn(long returnMoney, long inputMoney) {
    this(new Money(returnMoney), new Money(inputMoney));
  }

  public RateOfReturn(Money returnMoney, Money inputMoney) {
    checkInputMoney(inputMoney);
    rate = (double) returnMoney.value() / inputMoney.value();
  }

  public double rate() {
    return rate;
  }

  private void checkInputMoney(Money inputMoney) {
    if (inputMoney.equals(new Money(0))) {
      throw new IllegalArgumentException("수익률을 계산핼때, 초기투자금액으로 0원을 사용할수 없습니다.");
    }
  }
}
