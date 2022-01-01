package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  @DisplayName("Test create.")
  void testCreate() {
    assertEquals(1000, new Money(1000).getValue());
  }

  @Test
  @DisplayName("Test throw exception when money is less than 0.")
  void testThrows() {
    assertThrows(IllegalArgumentException.class, () -> new Money(-1));
  }
}
