package lotto;

import static util.Validator.validateArgument;

public class Credit {

  private static final String MESSAGE_FOR_INVALID_CREDIT_AMOUNT = "크레딧은 0 이상 이어야 합니다.";
  private static final String MESSAGE_FOR_INVALID_CREDIT_AMOUNT_WITH_LOTTO_PRICE = "구입 금액은 최소 로또가격(%s) 이상이어야 합니다.";

  private int balance;

  public Credit(int credit){
    validateCredit(credit);
    this.balance = credit;
  }

  public Credit purchase(int productPrice) {
    validateProductPrice(productPrice);
    return new Credit(balance - productPrice);
  }

  public int calculatePurchaseAmount(int productPrice) {
    validateProductPrice(productPrice);
    return balance / productPrice;
  }

  private void validateCredit(int credit) {
    validateArgument(
        credit,
        (arg) -> credit >= 0,
        MESSAGE_FOR_INVALID_CREDIT_AMOUNT
    );
  }

  private void validateProductPrice(int productPrice) {
    validateArgument(
        balance,
        (arg) -> productPrice > 0 && balance >= productPrice,
        String.format(MESSAGE_FOR_INVALID_CREDIT_AMOUNT_WITH_LOTTO_PRICE, productPrice)
    );
  }
}
