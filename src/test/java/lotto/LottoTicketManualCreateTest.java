package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.domain.PurchaseAmount.INVALID_MANUAL_PURCHASE_COUNT_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketManualCreateTest {

  private static List<Set<Integer>> MANUAL_LOTTO_TICKETS;

  @BeforeAll
  static void beforeAll() {
    MANUAL_LOTTO_TICKETS = List.of(
        Set.of(8, 21, 23, 41, 42, 43),
        Set.of(3, 5, 11, 16, 32, 38),
        Set.of(7, 11, 16, 35, 36, 44)
    );
  }

  @Test
  @DisplayName("구입금액보다 수동 구매할 로또 수가 큰 경우 테스트")
  void lottoTicketManualCreateTest() {
    int inputPurchaseAmount = 2000;
    int manualPurchaseCount = 3;
    assertThatThrownBy(() -> PurchaseAmount.of(inputPurchaseAmount, manualPurchaseCount))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_MANUAL_PURCHASE_COUNT_INPUT, inputPurchaseAmount, manualPurchaseCount));
  }

  @Test
  @DisplayName("수동과 자동 섞였을 때 정상 생성 테스트")
  void lottoTicketManualCreateTest2() {
    int inputPurchaseAmount = 5000;
    int manualPurchaseCount = 3;
    PurchaseAmount purchaseAmount = PurchaseAmount.of(inputPurchaseAmount, manualPurchaseCount);
    LottoTickets lottoTickets = LottoTickets.purchaseBy(purchaseAmount, MANUAL_LOTTO_TICKETS);
    assertThat(lottoTickets.allTicketCount()).isEqualTo(5);
  }

  @Test
  @DisplayName("수동 구매할 로또 수 음수인 경우 테스트")
  void lottoTicketManualCreateTest3() {
    int inputPurchaseAmount = 2000;
    int manualPurchaseCount = -1;
    assertThatThrownBy(() -> PurchaseAmount.of(inputPurchaseAmount, manualPurchaseCount))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INVALID_MANUAL_PURCHASE_COUNT_INPUT, inputPurchaseAmount, manualPurchaseCount));
  }
}
