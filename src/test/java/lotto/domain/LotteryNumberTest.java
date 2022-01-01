package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteryNumberTest {

  @Test
  @DisplayName("Test lottery number.")
  void testLotteryNumber() {
    assertEquals(1, new LotteryNumber(1).number());
    assertEquals(new LotteryNumber(1), new LotteryNumber(1));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 46, 100})
  @DisplayName("Test throw exception when create invalid lottery number.")
  void testThrowException(int number) {
    assertThrows(IllegalArgumentException.class, () -> new LotteryNumber(number));
  }
}
