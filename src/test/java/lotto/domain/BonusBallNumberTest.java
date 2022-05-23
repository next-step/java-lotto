package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusBallNumberTest {

  @DisplayName("보너스볼이 null 이면 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void nullBonusBallNumber(Integer number) {
    assertThatIllegalArgumentException().isThrownBy(
            () -> BonusBallNumber.createBonusBallNumber(number))
        .withMessageContaining("보너스볼은 null일 수 없습니다.");
  }

  @DisplayName("LottoTicket이 null 이면 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void nullLottoTicket(LottoTicket lottoTicket) {
    assertThatIllegalArgumentException().isThrownBy(
            () -> BonusBallNumber.createBonusBallNumber(lottoTicket, 1))
        .withMessageContaining("로또 번호는 null일 수 없습니다.");
  }

  @DisplayName("보너스볼 범위를 벗어난 값은 예외를 던진다")
  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void bonusBallNumberOutOfBounds(Integer number) {
    assertThatIllegalArgumentException().isThrownBy(
            () -> BonusBallNumber.createBonusBallNumber(number))
        .withMessageMatching("\\d+ 로또번호 범위가 올바르지 않습니다.");
  }

  @DisplayName("로또 번호 6개 중 보너스볼이 일치하면 참을 반환한다")
  @ParameterizedTest
  @MethodSource("provideForMatchAny")
  void matchAny(LottoTicket lottoTicket, BonusBallNumber bonusBallNumber, boolean expect) {
    assertThat(bonusBallNumber.matchAny(lottoTicket)).isEqualTo(expect);
  }

  private static Stream<Arguments> provideForMatchAny() {
    LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    return Stream.of(
        arguments(lottoTicket, BonusBallNumber.createBonusBallNumber(1), true),
        arguments(lottoTicket, BonusBallNumber.createBonusBallNumber(7), false)
    );
  }

  @DisplayName("보너스 번호를 생성 시 우승 로또번호와 중복되는 번호는 예외를 던진다")
  @Test
  void duplicateNumber() {
    LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    assertThatIllegalArgumentException().isThrownBy(
            () -> BonusBallNumber.createBonusBallNumber(lottoTicket, 1))
        .withMessageMatching("\\d+: 보너스볼 번호는 로또 번호와 중복된 번호일 수 없습니다.");
  }
}