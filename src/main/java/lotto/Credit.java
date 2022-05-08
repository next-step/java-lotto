package lotto;

import static util.Validator.validateArgument;

public class Credit {

  private static final String MESSAGE_FOR_INVALID_CREDIT_AMOUNT = "구입 금액은 양수이어야 합니다.";
  private static final String MESSAGE_FOR_INVALID_CREDIT_AMOUNT_WITH_LOTTO_PRICE = "구입 금액은 최소 로또가격(%s) 이상이어야 합니다.";

  private int balance;

  public Credit(int credit){
    validateCredit(credit);
    this.balance = credit;
  }

  public int purchase(int productPrice) {
    validateProductPrice(productPrice);
    int purchaseAmount = balance / productPrice;
    balance -= productPrice;
    return purchaseAmount;
  }

  public int calculatePurchaseAmount(int productPrice) {
    validateProductPrice(productPrice);
    return balance / productPrice;
  }

  private void validateCredit(int credit) {
    validateArgument(
        credit,
        (arg) -> credit > 0,
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
