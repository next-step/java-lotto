package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import java.util.List;
import lotto.domain.money.Money;
import lotto.domain.strategy.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    assertThat(tickets.randomLottoCount()).isEqualTo(lottoCount);
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
  void payThrowsNullPointException(Integer moneyWon) {
    assertThatNullPointerException().isThrownBy(
        () -> lotteryShop.sell(Money.createWon(moneyWon), randomNumbers));
  }

  @DisplayName("수동번호가 null 이면 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void manualLottoNumberException(List<String> manualLottoNumbers) {
    assertThatIllegalArgumentException().isThrownBy(
        () -> lotteryShop.sell(Money.createWon(1000), randomNumbers, manualLottoNumbers));
  }

  @DisplayName("수동으로 구매할 로또 수가 구매 금액을 초과하면 에외를 던진다.")
  @Test
  void exceedManualLottoPrice() {
    List<String> manualLottoNumbers = List.of("1,2,3,4,5,6", "1,2,3,4,5,7", "1,2,3,4,5,8");
    assertThatIllegalArgumentException().isThrownBy(
            () -> lotteryShop.sell(Money.createWon(2000), randomNumbers, manualLottoNumbers))
        .withMessageMatching("수동 구매 로또 개수.+?가 구입 가능한 개수.+?보다 많을 수 없습니다");
  }
}