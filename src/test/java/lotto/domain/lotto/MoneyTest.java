package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MoneyTest {
  @Test
  void negativeAmountThrowsException() {
    assertThatThrownBy(() -> new Money(-1000))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("금액은 0이상이어야 합니다");
  }

  @Test
  void calculateRatioByZeroThrowsException() {
    Money money = new Money(1000);
    assertThatThrownBy(() -> money.calculateRatio(new Money(0)))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("몫은 0보다 커야 합니다");
  }
}
