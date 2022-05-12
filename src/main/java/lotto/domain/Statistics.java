package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.domain.money.Money;

public class Statistics {

  private final List<Statistic> statistics;

  private static final String EMPTY_STATISTICS = "통계는 빈 값일 수 없습니다.";

  public Statistics(List<Statistic> statistics) {
    validate(statistics);
    this.statistics = statistics;
  }

  private void validate(List<Statistic> statistics) {
    if (statistics == null || statistics.isEmpty()) {
      throw new IllegalArgumentException(EMPTY_STATISTICS);
    }
  }

  public Money summingTotalPrizeAmount() {
    return statistics.stream()
        .map(Statistic::getTotalPrize)
        .reduce(Money::sum)
        .orElse(Money.createWon(0));
  }

  public List<Statistic> getStatistics() {
    return Collections.unmodifiableList(statistics);
  }
}
