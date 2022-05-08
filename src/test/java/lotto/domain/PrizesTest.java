package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizesTest {

  @DisplayName("일치하는 번호개수 별 당첨금 수령액 검증")
  @ParameterizedTest
  @MethodSource("provideForPrizes")
  void prizes(int count, Money prize) {
    assertThat(Prizes.of(count)).isEqualTo(prize);
  }

  private static Stream<Arguments> provideForPrizes() {
    return Stream.of(
        arguments(6, Money.of(2_000_000_000)),
        arguments(5, Money.of(1_500_000)),
        arguments(4, Money.of(50_000)),
        arguments(3, Money.of(5_000)),
        arguments(2, Money.of(0)),
        arguments(1, Money.of(0)),
        arguments(0, Money.of(0))
    );
  }
}