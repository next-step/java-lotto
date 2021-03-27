package lotto.domain;

import java.util.List;
import lotto.view.StatisticsDto;

public class Statistics {

  private List<Integer> lottoResults;
  private Money winPrice;

  public Statistics(List<Integer> lottoResults) {
    this.lottoResults = lottoResults;
  }

  public long calculateStatistics(StatisticsDto dto) {
    int count = Long.valueOf(lottoResults.stream()
        .filter(number -> number == dto.getCount())
        .count()).intValue();

    if (winPrice == null) {
      winPrice = new Money(0);
    }

    winPrice = winPrice.plus(accumulatePrice(dto.getPrice(), count));
    return count;
  }

  private Money accumulatePrice(Money price, int count) {
    return price.multiply(count);
  }

  public double getEarningRate(Money investMoney) {
    return winPrice.calculateRate(investMoney);
  }
}
