package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoAgency {

  private static final int LOTTO_PER_PRICE = 1000;

  private final LottoCoupon coupon;
  private final Money money;
  private Lotto winLottoNumbers;

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

  public void updateWinLottoNumbers(Lotto winLottoNumbers) {
    this.winLottoNumbers = winLottoNumbers;
  }

  public Lotto getWinLottoNumbers() {
    return winLottoNumbers;
  }

  public String printLottoCoupon() {
    return this.coupon.toString();
  }

  public WinningBoard getTotalResult() {
    List<Integer> lottoMatchResult = new ArrayList<>();
    for(int i = 0; i < getPurchaseQuantity(); i++) {
      lottoMatchResult.add(eachResult(i));
    }
    return WinningBoard.createLottoResult(lottoMatchResult, money);
  }

  private int eachResult(int index) {
    List<Number> winNumber = getWinLottoNumbers().getNumbers();
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
