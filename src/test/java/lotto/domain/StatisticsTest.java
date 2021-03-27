package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import lotto.view.StatisticsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

  @DisplayName("통계 계산 케이스 1")
  @Test
  void calculate_statistics_case1() {
    Statistics statistics = new Statistics(Arrays.asList(0, 0, 3));
    long result = statistics.calculateStatistics(new StatisticsDto(3, new Money(1000)));
    assertThat(result).isEqualTo(1);

    double earningRate = statistics.getEarningRate(new Money(3000));
    assertThat(earningRate).isEqualTo(calculate(1000, 3000));
  }

  @DisplayName("통계 계산 케이스 2")
  @Test
  void calculate_statistics_case2() {
    Statistics statistics = new Statistics(Arrays.asList(0, 0, 3, 4, 3, 4, 3, 3, 4, 4, 4, 4));
    long result3 = statistics.calculateStatistics(new StatisticsDto(3, new Money(1000)));
    long result4 = statistics.calculateStatistics(new StatisticsDto(4, new Money(10000)));

    assertThat(result3).isEqualTo(4);
    assertThat(result4).isEqualTo(6);

    double earningRate = statistics.getEarningRate(new Money(12000));
    assertThat(earningRate).isEqualTo(calculate(64000,12000));
  }

  private double calculate(int win, int invest) {
    return
        new BigDecimal(win)
            .divide(new BigDecimal(invest), 2, RoundingMode.HALF_UP)
            .doubleValue();
  }

}