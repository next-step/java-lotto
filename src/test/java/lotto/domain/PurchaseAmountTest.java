package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest {
  @Test
  void 티켓갯수() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(100000);
    assertThat(purchaseAmount.getTicketCount()).isEqualTo(100);
  }
}