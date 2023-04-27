package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
  @Test
  void 티켓갯수() {
    Money purchaseAmount = new Money(100000);
    assertThat(purchaseAmount.getPurchasableTicketCount()).isEqualTo(100);
  }
}