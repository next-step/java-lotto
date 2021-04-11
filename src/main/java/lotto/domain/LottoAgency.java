package lotto.domain;

import java.util.Objects;

public class LottoAgency {

  private static final int LOTTO_PER_PRICE = 1000;

  private final LottoCoupon coupon;
  private final Money money;

  public LottoAgency(Money money, LottoCoupon manualLottoCoupon) {
    this.money = money;
    this.coupon = manualLottoCoupon;
  }

  public int purchaseLotto() {
    LottoCoupon lottoCoupon = LottoCoupon.createLottoCoupon(availablePurchaseQuantity());
    updateLottoCoupon(lottoCoupon);
    return lottoCoupon.size();
  }

  public int availablePurchaseQuantity() {
    return money.divide(LOTTO_PER_PRICE) - coupon.size();
  }

  public int currentBoughtCouponQuantity() {
    return coupon.size();
  }

  public LottoScoreBoard getLottoResult(WinningNumber winningNumber) {
    return LottoScoreBoard.createLottoResult(money, coupon.matches(winningNumber));
  }

  public String lottoCouponToString() {
    return coupon.toString();
  }

  private void updateLottoCoupon(LottoCoupon lottoCoupon) {
    this.coupon.add(lottoCoupon);
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
