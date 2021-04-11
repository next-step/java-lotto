package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoCoupon {
  private final List<Lotto> lottoCoupon;

  public LottoCoupon(List<Lotto> lottoCoupon) {
    this.lottoCoupon = lottoCoupon;
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

  public LottoRanks matches(WinningNumber winningNumber) {
    return new LottoRanks(lottoCoupon.stream()
        .map(winningNumber::match)
        .collect(Collectors.toList()));
  }

  public int size() {
    return lottoCoupon.size();
  }

  public void add(LottoCoupon target) {
    lottoCoupon.addAll(target.lottoCoupon);
  }

  public boolean contains(Lotto lotto) {
    return lottoCoupon.contains(lotto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(Lotto lotto : lottoCoupon) {
      sb.append("[")
          .append(lotto.toString())
          .append("]")
          .append("\n");
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
    return Objects.equals(lottoCoupon, that.lottoCoupon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoCoupon);
  }
}
