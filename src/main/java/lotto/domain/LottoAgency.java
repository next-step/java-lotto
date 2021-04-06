package lotto.domain;

import java.util.Objects;

public class LottoAgency {

  private static final int LOTTO_PER_PRICE = 1000;

  private final LottoCoupon coupon;
  private Money money;

  public LottoAgency(Money money, LottoCoupon manualLottoCoupon) {
    this.money = money;
    this.coupon = manualLottoCoupon;
    updateBalance(manualLottoCoupon.size());
  }

  public int purchaseLotto() {
    LottoCoupon lottoCoupon = LottoCoupon.createLottoCoupon(availablePurchaseQuantity());
    updateLottoCoupon(lottoCoupon);
    updateBalance(lottoCoupon.size());
    return lottoCoupon.size();
  }

  public Money originMoney() {
    if(money.lagerThan(0)) {
      return money.sum(money.multiple(coupon.size(), LOTTO_PER_PRICE));
    }
    return new Money(money.multiple(coupon.size(), LOTTO_PER_PRICE));
  }

  public int availablePurchaseQuantity() {
    return money.divide(LOTTO_PER_PRICE);
  }

  public int currentBoughtCouponQuantity() {
    return coupon.size();
  }

  public LottoScoreBoard getLottoResult(WinningNumber winningNumber) {
    return winningNumber.generateLottoMatchResult(originMoney(), coupon, winningNumber);
  }

  public String lottoCouponToString() {
    return coupon.toString();
  }

  private void updateLottoCoupon(LottoCoupon lottoCoupon) {
    this.coupon.add(lottoCoupon);
  }

  private void updateBalance(int size) {
    this.money = money.subtract(new Money(money.multiple(size, LOTTO_PER_PRICE)));
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
