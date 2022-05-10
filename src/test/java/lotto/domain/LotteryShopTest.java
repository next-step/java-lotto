package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryShopTest {

  private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
  private final LotteryShop lotteryShop = new LotteryShop();

  @DisplayName("금액에 맞는 횟수만큼 로또 발급")
  @ParameterizedTest
  @CsvSource(value = {"1000:1", "1100:1", "2000:2"}, delimiter = ':')
  void payForPlayLotto(Integer moneyWon, Integer lottoCount) {
    LottoTickets tickets = lotteryShop.sell(Money.of(moneyWon), lottoNumberGenerator);
    assertThat(tickets.size()).isEqualTo(lottoCount);
  }

  @DisplayName("1000원 미만, 음수값 입력시 IllegalArgument 예외를 던진다")
  @ParameterizedTest
  @ValueSource(ints = {999, -1})
  void payThrowsIllegalArgumentException(Integer moneyWon) {
    assertThatIllegalArgumentException().isThrownBy(
            () -> lotteryShop.sell(Money.of(moneyWon), lottoNumberGenerator))
        .withMessageMatching("로또 1장의 가격은 \\d+원 입니다");
  }

  @DisplayName("null 값 입력시 Null Pointer 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void payThrowsNullPointExceptionException(Integer moneyWon) {
    assertThatNullPointerException().isThrownBy(
        () -> lotteryShop.sell(Money.of(moneyWon), lottoNumberGenerator));
  }
}