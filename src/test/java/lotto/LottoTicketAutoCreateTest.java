package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static lotto.domain.PurchaseAmount.INVALID_PURCHASE_AMOUNT_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketAutoCreateTest {

  @ParameterizedTest
  @ValueSource(ints = {3000, 6000, 24000})
  @DisplayName("구입 금액과 수동 구매 갯수를 입력하여," +
      "LottoTickets을 생성할 수 있으며" +
      "입력받은 구입 금액이 정상적으로 저장되는지 검증")
  void lottoCreateTest(int given) {
    LottoTickets lottoTickets = LottoTickets.purchaseBy(PurchaseAmount.of(given, 0), Collections.emptyList());
    assertThat(lottoTickets.isSamePurchaseAmount(given)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({
      "3000,3",
      "6000,6",
      "24000,24"
  })
  @DisplayName("구입 금액과 수동 구매 갯수를 입력하여," +
      "LottoTickets을 생성할 수 있으며" +
      "입력받은 구입 금액 -> 로또 '장'수로 컨버팅하는 기능 검증")
  void lottoCreateTest2(int given, int expected) {
    LottoTickets lottoTickets = LottoTickets.purchaseBy(PurchaseAmount.of(given, 0), Collections.emptyList());
    assertThat(lottoTickets.autoTicketCount()).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 600, 3500, 6700, 24010})
  @DisplayName("구입 금액과 수동 구매 갯수를 입력하여," +
      "LottoTickets을 생성 시" +
      "LottoTicket을 구입할 수 있는 금액 단위(1000단위)가 아닌 경우 exception 테스트")
  void lottoCreateTest3(int given) {
    assertThatThrownBy(() -> LottoTickets.purchaseBy(PurchaseAmount.of(given, 0), Collections.emptyList()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_PURCHASE_AMOUNT_INPUT, given));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -3000, -6000, -24000})
  @DisplayName("구입 금액과 수동 구매 갯수를 입력하여," +
      "LottoTickets을 생성 시" +
      "LottoTicket을 구입할 수 있는 금액이 양수가 아닌 경우 exception 테스트")
  void lottoCreateTest4(int given) {
    assertThatThrownBy(() -> LottoTickets.purchaseBy(PurchaseAmount.of(given, 0), Collections.emptyList()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_PURCHASE_AMOUNT_INPUT, given));
  }

  @ParameterizedTest
  @ValueSource(ints = {3000, 6000, 24000})
  @DisplayName("구입 금액과 수동 구매 갯수를 입력하여," +
      "LottoTickets을 생성할 수 있으며" +
      "생성된 LottoTicket별 로또 숫자가 모두 6개인지 검증")
  void lottoCreateTest5(int given) {
    LottoTickets lottoTickets = LottoTickets.purchaseBy(PurchaseAmount.of(given, 0), Collections.emptyList());
    assertThat(lottoTickets.haveAll6Numbers()).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {1000, 3000, 6000})
  @DisplayName("구입 금액과 수동 구매 갯수를 입력하여," +
      "LottoTickets을 생성할 수 있으며" +
      "생성된 LottoTicket별 로또 숫자가 모두 1 ~ 45 내의 숫자로 생성되는지 검증")
  void lottoCreateTest7(int given) {
    LottoTickets lottoTickets = LottoTickets.purchaseBy(PurchaseAmount.of(given, 0), Collections.emptyList());
    ;
    assertThat(lottoTickets.haveCorrectNumbers()).isTrue();
  }
}
