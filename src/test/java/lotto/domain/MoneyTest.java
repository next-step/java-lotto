package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

  @Test
  void 현재_가진돈보다_더많은돈을_사용하면_IllegalArgumentException이_발생한다() {
    assertThatThrownBy(() -> money.difference(new Money(110000)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("현재 가진 돈보다 더 많은 돈을 사용할 수 없습니다.");
  }
}