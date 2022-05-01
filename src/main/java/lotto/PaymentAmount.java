package lotto;

import static util.Validator.validateArgument;

public class PaymentAmount {

  private static final String MESSAGE_FOR_INVALID_PAYMENT_AMOUNT = "구입 금액은 양수이어야 합니다.";
  private static final String MESSAGE_FOR_INVALID_PAYMENT_AMOUNT_WITH_LOTTO_PRICE = "구입 금액은 최소 로또가격(%s) 이상이어야 합니다.";

  private final int paymentAmount;

  public PaymentAmount(int paymentAmount){
    validatePayment(paymentAmount);
    this.paymentAmount = paymentAmount;
  }

  public int purchaseLotto(int lottoPrice) {
    validateLottoPrice(lottoPrice);
    return paymentAmount / lottoPrice;
  }

  private void validatePayment(int paymentAmount) {
    validateArgument(
        paymentAmount,
        (arg) -> paymentAmount > 0,
        MESSAGE_FOR_INVALID_PAYMENT_AMOUNT
    );
  }

  private void validateLottoPrice(int lottoPrice) {
    validateArgument(
        paymentAmount,
        (arg) -> lottoPrice > 0 && paymentAmount >= lottoPrice,
        String.format(MESSAGE_FOR_INVALID_PAYMENT_AMOUNT_WITH_LOTTO_PRICE, lottoPrice)
    );
  }
}
