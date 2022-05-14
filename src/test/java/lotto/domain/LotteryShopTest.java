package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import lotto.domain.money.Money;
import lotto.domain.strategy.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryShopTest {

  private final RandomNumbers randomNumbers = new RandomNumbers();
  private final LotteryShop lotteryShop = new LotteryShop();

  @DisplayName("금액에 맞는 횟수만큼 로또 발급")
  @ParameterizedTest
  @CsvSource(value = {"1000:1", "1100:1", "2000:2"}, delimiter = ':')
  void payForPlayLotto(Integer moneyWon, Integer lottoCount) {
    LottoTickets tickets = lotteryShop.sell(Money.createWon(moneyWon), randomNumbers);
    assertThat(tickets.size()).isEqualTo(lottoCount);
  }

  @DisplayName("1000원 미만값 입력시 IllegalArgument 예외를 던진다")
  @ParameterizedTest
  @ValueSource(ints = {999, 0})
  void payThrowsIllegalArgumentException(Integer moneyWon) {
    assertThatIllegalArgumentException().isThrownBy(
            () -> lotteryShop.sell(Money.createWon(moneyWon), randomNumbers))
        .withMessageMatching("로또 1장의 가격은 \\d+원 입니다");
  }

  @DisplayName("null 값 입력시 Null Pointer 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void payThrowsNullPointExceptionException(Integer moneyWon) {
    assertThatNullPointerException().isThrownBy(
        () -> lotteryShop.sell(Money.createWon(moneyWon), randomNumbers));
  }
}