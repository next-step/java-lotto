package lotto.domain;

import java.util.Objects;

public class LottoAgency {

  private static final int LOTTO_PER_PRICE = 1000;

  private final LottoCoupon coupon;
  private final Money money;

  public LottoAgency(Money money) {
    this.money = money;
    this.coupon = purchaseLotto();
  }

  public LottoCoupon purchaseLotto() {
    return LottoCoupon.createLottoCoupon(getPurchaseQuantity());
  }

  public Money getSeedMoney() {
    return money.multiple(LOTTO_PER_PRICE);
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
