package lotto.domain;

import java.util.ArrayList;
import java.util.List;
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

  public int getPurchaseQuantity() {
    return money.divide(LOTTO_PER_PRICE);
  }

  public LottoCoupon getCoupon() {
    return new LottoCoupon(coupon.getLottoCoupon());
  }

  public LottoScoreBoard getLottoResult(Lotto winNumbers, final Number bonusBall) {
    List<LottoRank> lottoMatchResult = new ArrayList<>();
    for(int i = 0; i < getPurchaseQuantity(); i++) {
      lottoMatchResult.add(eachResult(i, winNumbers, bonusBall));
    }
    return LottoScoreBoard.createLottoResult(lottoMatchResult, money);
  }

  private LottoRank eachResult(int index, Lotto winNumbers, Number bonusBall) {
    List<Number> winningNumbers = winNumbers.getNumbers();
    List<Number> holdingLottoNumbers = coupon.getLottoCoupon()
        .get(index)
        .getNumbers();

    return LottoRank.matches(winningNumbers, holdingLottoNumbers, bonusBall);
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
