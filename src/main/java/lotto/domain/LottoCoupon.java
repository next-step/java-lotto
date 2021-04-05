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
    return new ArrayList<>(lottoCoupon);
  }

  public static LottoCoupon createLottoCoupon(int howMany) {
    List<Lotto> lottoList = new ArrayList<>();
    for(int i = 0; i < howMany; i++) {
      lottoList.add(Lotto.createAutoLotto());
    }
    return new LottoCoupon(lottoList);
  }

  public static LottoCoupon asLottoCoupon(List<Lotto> lottos) {
    return new LottoCoupon(lottos);
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
