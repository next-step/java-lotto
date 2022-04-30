package lotto.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  @DisplayName("돈은 음수를 가질 수 없습니다.")
  void moneyNotNegativeException() {
    assertThrows(RuntimeException.class, () -> {
      Money money = new Money(-1L);
    });
  }

  @Test
  @DisplayName("돈을 가지고 있지 않으면 로또를 가질 수 없습니다.")
  void moneyEmptyException() {
    assertThrows(RuntimeException.class, () -> {
      Money money = new Money();
    });
  }
}