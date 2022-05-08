package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("당첨 통계 테스트")
class StatisticTest {

  @DisplayName("Statistic은 당첨금 총액을 반환한다")
  @ParameterizedTest
  @MethodSource("provideForStatistic")
  void statistic(int prizeCount, Prizes prize, Money money) {
    Statistic statistic = new Statistic(prizeCount, prize);
    assertThat(statistic.getTotalPrize()).isEqualTo(money);
  }

  private static Stream<Arguments> provideForStatistic() {
    return Stream.of(
        arguments(0, Prizes.FIRST, Money.ZERO),
        arguments(0, Prizes.SECOND, Money.ZERO),
        arguments(2, Prizes.THIRD, Money.of(50_000 * 2)),
        arguments(1, Prizes.FOURTH, Money.of(5_000))
    );
  }
}