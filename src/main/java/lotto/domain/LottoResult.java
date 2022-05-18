package lotto.domain;

import java.util.List;

public class LottoResult {

  public final List<Rank> top;

  public LottoResult(List<Rank> top) {
    this.top = top;
  }

  public Money totalPrizeAmount() {
    return Money.from(top.stream()
        .mapToLong(Rank::getCashPrize)
        .sum());
  }
}
