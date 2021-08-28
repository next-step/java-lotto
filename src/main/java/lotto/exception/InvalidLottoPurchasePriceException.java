package lotto.exception;

import lotto.domain.Lotto;

public class InvalidLottoPurchasePriceException extends IllegalArgumentException {

  public InvalidLottoPurchasePriceException() {
    super("최소 구매 금액은 " + Lotto.PRICE.value() + "원 입니다.");
  }
}
