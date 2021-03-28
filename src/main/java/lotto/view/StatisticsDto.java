package lotto.view;

import lotto.domain.Money;
import lotto.domain.Ranking;

public class StatisticsDto {

  private Ranking ranking;
  private Money price;

  public StatisticsDto(Ranking ranking) {
    this.ranking = ranking;
  }

  public StatisticsDto(Ranking ranking, Money price) {
    this.ranking = ranking;
    this.price = price;
  }

  public Ranking getRanking() {
    return ranking;
  }

}
