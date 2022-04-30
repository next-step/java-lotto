package lotto.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  @DisplayName("1000원 이하의 돈으로는 로또를 구입할 수 없습니다.")
  void moneyNotNegativeException() {
    assertThrows(RuntimeException.class, () -> {
      new Money(-1L);
      new Money(999L);
    });
  }

}