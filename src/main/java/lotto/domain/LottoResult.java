package lotto.domain;

import java.util.List;

public class LottoResult {

  public final List<Rank> ranks;

  public LottoResult(List<Rank> ranks) {
    this.ranks = ranks;
  }

  public long countByRank(final Rank lottoRank) {
    return ranks.stream()
        .filter(rank -> rank.equals(lottoRank))
        .count();
  }

  public Money totalPrizeAmount() {
    return Money.from(ranks.stream()
        .mapToLong(Rank::getCashPrize)
        .sum());
  }
}
