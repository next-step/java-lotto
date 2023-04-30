package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
  private Money money;

  @BeforeEach
  void setUp() {
    money = new Money(100000);
  }

  @Test
  void 티켓갯수() {
    assertThat(money.getPurchasableTicketCount())
        .isEqualTo(100);
  }

  @Test
  void 금액을_반환한다() {
    assertThat(money.getAmount())
        .isEqualTo(100000);
  }

  @Test
  void minus() {
    assertThat(money.difference(new Money(5000)))
        .isEqualTo(new Money(95000));
  }
}