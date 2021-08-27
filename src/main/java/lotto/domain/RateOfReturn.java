package lotto.domain;

import lotto.exception.DividedByZeroException;

public class RateOfReturn {

  private final double rate;

  public RateOfReturn(long returnMoney, long inputMoney) {
    this(new Money(returnMoney), new Money(inputMoney));
  }

  public RateOfReturn(Money returnMoney, Money inputMoney) {
    validateInputMoney(inputMoney);
    rate = (double) returnMoney.value() / inputMoney.value();
  }

  public double rate() {
    return rate;
  }

  private void validateInputMoney(Money inputMoney) {
    if (inputMoney.equals(new Money(0))) {
      throw new DividedByZeroException();
    }
  }
}
