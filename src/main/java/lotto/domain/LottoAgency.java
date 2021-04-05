package lotto.domain;

import java.util.Objects;

public class LottoAgency {

  private static final int LOTTO_PER_PRICE = 1000;

  private final LottoCoupon coupon;
  private Money money;

  public LottoAgency(Money money) {
    this.money = money;
    this.coupon = purchaseLotto();
  }

  public LottoCoupon purchaseLotto() {
    return LottoCoupon.createLottoCoupon(getPurchaseQuantity());
  }

  public Money getSeedMoney() {
    return new Money(money.multiple(LOTTO_PER_PRICE));
  }

  public Money lottoPurchaseMoney(Number quantity) {
    return new Money(quantity.multiple(LOTTO_PER_PRICE));
  }

  public void updateBalance(Money purchaseAmount) {
    this.money = money.subtract(purchaseAmount);
  }

  public int getPurchaseQuantity() {
    return money.divide(LOTTO_PER_PRICE);
  }

  public LottoCoupon getCoupon() {
    return new LottoCoupon(coupon.getLottoCoupon());
  }

  public LottoScoreBoard getLottoResult(WinningNumber winningNumber) {
    return winningNumber.generateLottoMatchResult(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LottoAgency)) {
      return false;
    }
    LottoAgency that = (LottoAgency) o;
    return Objects.equals(coupon, that.coupon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coupon);
  }
}
