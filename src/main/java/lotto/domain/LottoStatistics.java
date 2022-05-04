package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoStatistics {

  public static final int LOTTO_TICKET_PRICE = 1000;
  private final List<LottoResult> lottoResults;

  public LottoStatistics(List<LottoResult> lottoResults) {
    this.lottoResults = lottoResults;
  }

  public List<LottoResult> getLottoResults() {
    return Collections.unmodifiableList(lottoResults);
  }

  public Money getRateOfReturn() {
    return Money.wons(getTotalCashPrizeAmount())
        .divide(getTotalPaidAmount());
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
