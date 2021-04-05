package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  private Statistics statistics;

  @BeforeEach
  void setUp() {
    statistics = new Statistics();
  }

  @DisplayName("당첨 로또게임 세기")
  @Test
  void count_game() {
    statistics.recordRanking(Ranking.SECOND);
    Integer countGame = statistics.countGame(Ranking.SECOND);
    assertThat(countGame).isEqualTo(1);

    statistics.recordRanking(Ranking.SECOND);
    Integer updatedCountGame = statistics.countGame(Ranking.SECOND);
    assertThat(updatedCountGame).isEqualTo(2);
  }

  @DisplayName("수익률 계산")
  @Test
  void calculate_earning_rate() {
    statistics.recordRanking(Ranking.THIRD);
    assertThat(statistics.getEarningRate(new Money(10000))).isEqualTo(5.00);
  }


}