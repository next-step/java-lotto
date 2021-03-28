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
    return money.toInt() / LOTTO_PER_PRICE;
  }

  public LottoCoupon getCoupon() {
    return new LottoCoupon(coupon.getLottoCoupon());
  }

  public WinningBoard getTotalResult(Lotto winNumbers) {
    List<Integer> lottoMatchResult = new ArrayList<>();
    for(int i = 0; i < getPurchaseQuantity(); i++) {
      lottoMatchResult.add(eachResult(i, winNumbers));
    }
    return WinningBoard.createLottoResult(lottoMatchResult, money);
  }

  private int eachResult(int index, Lotto winNumbers) {
    List<Number> winNumber = winNumbers.getNumbers();
    List<Number> targetNumber = coupon.getLottoCoupon().get(index).getNumbers();

    int count = 0;
    for(int i = 0; i < winNumber.size(); i++) {
      count = isContain(winNumber, targetNumber, count, i);
    }
    return count;
  }

  private int isContain(List<Number> winNumber, List<Number> targetNumber, int count, int index) {
    if(winNumber.contains(targetNumber.get(index))) {
      count++;
    }
    return count;
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
