package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryNumberTest {

  @Test
  @DisplayName("Test create lottery number.")
  void testCreateLotteryNumber() {
    assertEquals(new LotteryNumber(1).getNumber(), 1);
  }

  @Test
  @DisplayName("Test throw exception when create invalid lottery number.")
  void testThrowException() {
    assertThrows(IllegalArgumentException.class, () -> new LotteryNumber(-1));
    assertThrows(IllegalArgumentException.class, () -> new LotteryNumber(50));
  }
}
