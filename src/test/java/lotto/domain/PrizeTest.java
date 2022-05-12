package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {

  @DisplayName("일치하는 번호개수 별 당첨금 수령액 검증")
  @ParameterizedTest
  @MethodSource("provideForPrize")
  void prize(int count, Money prize) {
    assertThat(Prize.getPrizeMoney(count)).isEqualTo(prize);
  }

  private static Stream<Arguments> provideForPrize() {
    return Stream.of(
        arguments(6, Money.createWon(2_000_000_000)),
        arguments(5, Money.createWon(1_500_000)),
        arguments(4, Money.createWon(50_000)),
        arguments(3, Money.createWon(5_000)),
        arguments(2, Money.createWon(0)),
        arguments(1, Money.createWon(0)),
        arguments(0, Money.createWon(0))
    );
  }
}