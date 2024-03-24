package lotto;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.PurchaseAmount.INVALID_PURCHASE_AMOUNT_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketAutoCreateTest {

  @ParameterizedTest
  @ValueSource(ints = {3000, 6000, 24000})
  @DisplayName("구입 금액 저장되는지 테스트")
  void lottoCreateTest(int given) {
    LottoTickets lottoTickets = LottoTickets.purchaseBy(given);
    assertThat(lottoTickets.isSamePurchaseAmount(given)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({
      "3000,3",
      "6000,6",
      "24000,24"
  })
  @DisplayName("구입 금액 -> 로또 '장'수로 컨버팅하는 기능")
  void lottoCreateTest2(int given, int expected) {
    LottoTickets lottoTickets = LottoTickets.purchaseBy(given);
    assertThat(lottoTickets.autoTicketCount()).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 600, 3500, 6700, 24010})
  @DisplayName("구입 금액 1000단위가 아닌 경우 테스트")
  void lottoCreateTest3(int given) {
    assertThatThrownBy(() -> LottoTickets.purchaseBy(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_PURCHASE_AMOUNT_INPUT, given));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -3000, -6000, -24000})
  @DisplayName("구입 금액이 양수가 아닌 경우 테스트")
  void lottoCreateTest4(int given) {
    assertThatThrownBy(() -> LottoTickets.purchaseBy(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_PURCHASE_AMOUNT_INPUT, given));
  }

  @ParameterizedTest
  @ValueSource(ints = {3000, 6000, 24000})
  @DisplayName("로또 숫자 6개씩 생성되는지 테스트")
  void lottoCreateTest5(int given) {
    LottoTickets lottoTickets = LottoTickets.purchaseBy(given);
    assertThat(lottoTickets.haveAll6Numbers()).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {1000, 3000, 6000})
  @DisplayName("로또 숫자 1 ~ 45 내의 숫자로 생성되는지 테스트")
  void lottoCreateTest7(int given) {
    LottoTickets lottoTickets = LottoTickets.purchaseBy(given);
    assertThat(lottoTickets.haveCorrectNumbers()).isTrue();
  }
}
