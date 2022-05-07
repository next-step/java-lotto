package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoResult {

  public static final int LOTTO_TICKET_PRICE = 1000;
  private final List<LottoRank> lottoRanks;

  public LottoResult(List<LottoRank> lottoRanks) {
    this.lottoRanks = lottoRanks;
  }

  public List<LottoRank> getLottoResults() {
    return Collections.unmodifiableList(lottoRanks);
  }

  public double getRateOfReturn() {
    return Money.wons(getTotalCashPrizeAmount())
        .divide(getTotalPaidAmount())
        .doubleValue();
  }

  public long getCountByLottoRank(final LottoRank lottoRank) {
    return lottoRanks.stream()
        .filter(rank -> rank.equals(lottoRank))
        .count();
  }

  private int getTotalPaidAmount() {
    return lottoRanks.size() * LOTTO_TICKET_PRICE;
  }

  private long getTotalCashPrizeAmount() {
    return lottoRanks.stream()
        .mapToLong(LottoRank::getCashPrize)
        .sum();
  }
}
