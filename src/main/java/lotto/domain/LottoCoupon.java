package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoCoupon {

  private final List<Lotto> lottoCoupon;

  public LottoCoupon(List<Lotto> lottoCoupon) {
    this.lottoCoupon = lottoCoupon;
  }

  public List<Lotto> getLottoCoupon() {
    return lottoCoupon;
  }

  public static LottoCoupon createLottoCoupon(int howMany) {
    List<Lotto> lottoList = new ArrayList<>();
    for(int i = 0; i < howMany; i++) {
      lottoList.add(Lotto.generatedAutoLottoNumber());
    }
    return new LottoCoupon(lottoList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(Lotto lotto : lottoCoupon) {
      sb.append(lotto.toString());
    }
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LottoCoupon)) {
      return false;
    }
    LottoCoupon that = (LottoCoupon) o;
    return Objects.equals(getLottoCoupon(), that.getLottoCoupon());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLottoCoupon());
  }
}
