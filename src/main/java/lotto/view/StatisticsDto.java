package lotto.view;

import lotto.domain.Ranking;

public class StatisticsDto {

  private Ranking ranking;

  public StatisticsDto(Ranking ranking) {
    this.ranking = ranking;
  }

  public Ranking getRanking() {
    return ranking;
  }

}
