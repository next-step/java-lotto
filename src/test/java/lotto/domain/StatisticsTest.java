package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StatisticsTest {

  @DisplayName("통계목록 생성 시 빈 값 또는 null은 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void emptyException(List<Statistic> statistics) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Statistics(statistics))
        .withMessage("통계는 빈 값일 수 없습니다.");
  }

  @DisplayName("총 상금을 반환한다")
  @ParameterizedTest
  @MethodSource("provideForStatistics")
  void summingTotalPrizeAmount(Statistics statistics, Money totalPrize) {
    assertThat(statistics.summingTotalPrizeAmount()).isEqualTo(totalPrize);
  }

  private static Stream<Arguments> provideForStatistics() {
    return Stream.of(
        arguments(
            new Statistics(List.of(new Statistic(1, Prize.THIRD), new Statistic(2, Prize.FIFTH))),
            Money.createWon(1_510_000)),
        arguments(new Statistics(
                List.of(new Statistic(5, Prize.NOT_PRIZE), new Statistic(1, Prize.FIRST))),
            Money.createWon(2_000_000_000))
    );
  }
}