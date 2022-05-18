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
  void prize(int count, boolean matchBonus, Money prize) {
    assertThat(Prize.of(count, matchBonus).getPrize()).isEqualTo(prize);
  }

  private static Stream<Arguments> provideForPrize() {
    return Stream.of(
        arguments(6, false, Money.createWon(2_000_000_000)),
        arguments(5, true, Money.createWon(30_000_000)),
        arguments(5, false, Money.createWon(1_500_000)),
        arguments(4, false, Money.createWon(50_000)),
        arguments(3, false, Money.createWon(5_000)),
        arguments(2, false, Money.createWon(0)),
        arguments(1, false, Money.createWon(0)),
        arguments(0, false, Money.createWon(0))
    );
  }

  @DisplayName("당첨금을 돈 객체로 반환한다")
  @ParameterizedTest
  @MethodSource("provideForGetPrize")
  void getPrize(Prize prize, Money money) {
    assertThat(prize.getPrize()).isEqualTo(money);
  }

  private static Stream<Arguments> provideForGetPrize() {
    return Stream.of(
        arguments(Prize.FIRST, Money.createWon(2_000_000_000)),
        arguments(Prize.SECOND, Money.createWon(30_000_000)),
        arguments(Prize.THIRD, Money.createWon(1_500_000)),
        arguments(Prize.FOURTH, Money.createWon(50_000)),
        arguments(Prize.FIFTH, Money.createWon(5_000)),
        arguments(Prize.NOT_PRIZE, Money.createWon(0))
    );
  }

  @DisplayName("로또 숫자 일치 갯수를 반환한다")
  @ParameterizedTest
  @MethodSource("provideForGetMoney")
  void getMatchCount(Prize prize, int matchCount) {
    assertThat(prize.getMatchCount()).isEqualTo(matchCount);
  }

  private static Stream<Arguments> provideForGetMoney() {
    return Stream.of(
        arguments(Prize.FIRST, 6),
        arguments(Prize.SECOND, 5),
        arguments(Prize.THIRD, 5),
        arguments(Prize.FOURTH, 4),
        arguments(Prize.FIFTH, 3),
        arguments(Prize.NOT_PRIZE, 0)
    );
  }

  @DisplayName("보너스 번호 일치여부를 반환한다")
  @ParameterizedTest
  @MethodSource("provideForIsMatchBonus")
  void isMatchBonus(Prize prize, boolean matched) {
    assertThat(prize.isMatchBonus()).isEqualTo(matched);
  }

  private static Stream<Arguments> provideForIsMatchBonus() {
    return Stream.of(
        arguments(Prize.FIRST, false),
        arguments(Prize.SECOND, true),
        arguments(Prize.THIRD, false),
        arguments(Prize.FOURTH, false),
        arguments(Prize.FIFTH, false),
        arguments(Prize.NOT_PRIZE, false)
    );
  }

  @DisplayName("당첨 여부를 반환한다.")
  @ParameterizedTest
  @MethodSource("provideForWinning")
  void winning(Prize prize, boolean expect) {
    assertThat(prize.winning()).isEqualTo(expect);
  }

  private static Stream<Arguments> provideForWinning() {
    return Stream.of(
        arguments(Prize.FIRST, true),
        arguments(Prize.SECOND, true),
        arguments(Prize.THIRD, true),
        arguments(Prize.FOURTH, true),
        arguments(Prize.FIFTH, true),
        arguments(Prize.NOT_PRIZE, false),
        arguments(Prize.NOT_PRIZE, false),
        arguments(Prize.NOT_PRIZE, false)
    );
  }
}