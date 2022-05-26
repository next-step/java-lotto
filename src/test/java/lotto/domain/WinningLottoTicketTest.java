package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class WinningLottoTicketTest {

  @DisplayName("null 또는 빈 우승번호는 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void winNumbers(String winNumbers) {
    assertThatIllegalArgumentException().isThrownBy(() -> WinningLottoTicket.of(winNumbers, "1"));
  }

  @DisplayName("로또 티켓의 보너스볼 일치여부를 반환한다")
  @ParameterizedTest
  @MethodSource("provideFormMatchBonus")
  void matchBonus(WinningLottoTicket winningLottoTicket, LottoTicket lottoTicket,
      boolean matchBonus) {
    assertThat(winningLottoTicket.matchBonusBall(lottoTicket)).isEqualTo(matchBonus);
  }

  private static Stream<Arguments> provideFormMatchBonus() {
    LottoTicket lottoTicket = LottoTicket.createLottoTicket(List.of(1, 3, 5, 7, 9, 11));
    String lottoNumbers = "1,2,3,4,5,6";
    return Stream.of(
        arguments(WinningLottoTicket.of(lottoNumbers, "7"), lottoTicket, true),
        arguments(WinningLottoTicket.of(lottoNumbers, "8"), lottoTicket, false),
        arguments(WinningLottoTicket.of(lottoNumbers, "9"), lottoTicket, true),
        arguments(WinningLottoTicket.of(lottoNumbers, "10"), lottoTicket, false),
        arguments(WinningLottoTicket.of(lottoNumbers, "11"), lottoTicket, true),
        arguments(WinningLottoTicket.of(lottoNumbers, "12"), lottoTicket, false),
        arguments(WinningLottoTicket.of(lottoNumbers, "13"), lottoTicket, false)
    );
  }
}