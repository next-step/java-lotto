package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryRetailerTest {

  private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
  private final LotteryRetailer lotteryRetailer = new LotteryRetailer();

  @DisplayName("금액에 맞는 횟수만큼 로또 발급")
  @ParameterizedTest
  @CsvSource(value = {"1000:1", "1100:1", "2000:2"}, delimiter = ':')
  void payForPlayLotto(Integer moneyWon, Integer lottoCount) {
    List<LottoTicket> tickets = lotteryRetailer.sell(moneyWon, lottoNumberGenerator);
    assertThat(tickets).hasSize(lottoCount);
  }

  @DisplayName("1000원 미만, 음수값 입력시 IllegalArgument 예외를 던진다")
  @ParameterizedTest
  @ValueSource(ints = {999, -1})
  void payThrowsIllegalArgumentException(Integer moneyWon) {
    assertThatIllegalArgumentException().isThrownBy(
            () -> lotteryRetailer.sell(moneyWon, lottoNumberGenerator))
        .withMessage("로또 1장의 가격은 1000원 입니다");
  }

  @DisplayName("null 값 입력시 Null Pointer 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void payThrowsNullPointExceptionException(Integer moneyWon) {
    assertThatNullPointerException().isThrownBy(
        () -> lotteryRetailer.sell(moneyWon, lottoNumberGenerator));
  }
}