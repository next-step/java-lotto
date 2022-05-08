package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryRetailerTest {

  private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
  private final LotteryRetailer lotteryRetailer = new LotteryRetailer();

  @DisplayName("금액에 맞는 횟수만큼 로또 발급")
  @ParameterizedTest
  @CsvSource(value = {"1000:1", "1100:1", "2000:2"}, delimiter = ':')
  void payForPlayLotto(Integer moneyWon, Integer lottoCount) {
    List<LottoTicket> tickets = lotteryRetailer.sell(Money.of(moneyWon), lottoNumberGenerator);
    assertThat(tickets).hasSize(lottoCount);
  }

  @DisplayName("1000원 미만, 음수값 입력시 IllegalArgument 예외를 던진다")
  @ParameterizedTest
  @ValueSource(ints = {999, -1})
  void payThrowsIllegalArgumentException(Integer moneyWon) {
    assertThatIllegalArgumentException().isThrownBy(
            () -> lotteryRetailer.sell(Money.of(moneyWon), lottoNumberGenerator))
        .withMessage("로또 1장의 가격은 1000원 입니다");
  }

  @DisplayName("null 값 입력시 Null Pointer 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void payThrowsNullPointExceptionException(Integer moneyWon) {
    assertThatNullPointerException().isThrownBy(
        () -> lotteryRetailer.sell(Money.of(moneyWon), lottoNumberGenerator));
  }

  @DisplayName("당첨금 계산")
  @ParameterizedTest
  @MethodSource("provideForWinPrizes")
  void winPrizes(LottoTicket winLottoTicket, LottoTicket lottoTicket, long prize) {
    assertThat(lotteryRetailer.exchange(lottoTicket, winLottoTicket)).isEqualTo(prize);
  }

  private static Stream<Arguments> provideForWinPrizes() {
    LottoTicket winLottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    return Stream.of(
        arguments(winLottoTicket, new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), 2_000_000_000),
        arguments(winLottoTicket, new LottoTicket(List.of(1, 2, 3, 4, 5, 7)), 1_500_000),
        arguments(winLottoTicket, new LottoTicket(List.of(1, 2, 3, 4, 7, 8)), 50_000),
        arguments(winLottoTicket, new LottoTicket(List.of(1, 2, 3, 7, 8, 9)), 5_000),
        arguments(winLottoTicket, new LottoTicket(List.of(1, 2, 7, 8, 9, 10)), 0),
        arguments(winLottoTicket, new LottoTicket(List.of(1, 7, 8, 9, 10, 11)), 0),
        arguments(winLottoTicket, new LottoTicket(List.of(7, 8, 9, 10, 11, 12)), 0)
    );
  }
}