package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoStatistics {

  public static final int LOTTO_TICKET_PRICE = 1000;
  private final List<LottoResult> lottoResults;

  public LottoStatistics(List<LottoResult> lottoResults) {
    this.lottoResults = lottoResults;
  }

  public List<LottoResult> getLottoResults() {
    return Collections.unmodifiableList(lottoResults);
  }

  public double getRateOfReturn() {
    return Money.wons(getTotalCashPrizeAmount())
        .divide(getTotalPaidAmount()).doubleValue();
  }

  public long getCountByLottoRank(final LottoRank lottoRank) {
    return lottoResults.stream()
        .filter(
            lottoResult -> Objects.equals(lottoResult, new LottoResult(lottoRank.getMatchCount())))
        .count();
  }

  private int getTotalPaidAmount() {
    return lottoResults.size() * LOTTO_TICKET_PRICE;
  }

  private long getTotalCashPrizeAmount() {
    return lottoResults.stream()
        .map(LottoResult::getLottoRank)
        .mapToLong(LottoRank::getCashPrize)
        .sum();
  }
}
