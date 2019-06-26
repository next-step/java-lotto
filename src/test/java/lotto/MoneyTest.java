package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  public void 금액에따른갯수를_리턴한다() {
    int money = 14000;
    assertThat(new Money(money).getAvailableQuantity()).isEqualTo(14);
  }

  @Test
  public void 금액이_0보다_작을수없다() {
    assertThatThrownBy(() -> {
      new Money(-1);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("금액은 0보다 커야 합니다.");
  }

  @Test
  public void 금액이_로또하나_가격보다_낮으면_예외처리한다() {
    assertThatThrownBy(() -> {
      new Money(900);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("로또를 살 수 없습니다.");
  }

}
