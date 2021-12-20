package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class  LotteryNumbersTest {

  @Test
  @DisplayName("Test create.")
  void testCreate() {
    assertEquals(6, new LotteryNumbers().getLotteryNumbers().size());
  }

  @Test
  @DisplayName("Test not equals even if the numbers are the same.")
  void testNotEquals() {
    assertNotEquals(
        LotteryNumbers.of(new int[] {1, 2, 3, 4, 5, 6}),
        LotteryNumbers.of(new int[] {1, 2, 3, 4, 5, 6})
    );
  }

  @Test
  @DisplayName("Test throw exception when the lottery's size is not 6.")
  void testThrowExceptionAboutSize() {
    assertThrows(
        IllegalArgumentException.class,
        () -> LotteryNumbers.of(new int[] {1, 2, 3, 4, 5, 6, 7})
    );
  }

  @Test
  @DisplayName("Test throw exception when the number of lotteries are duplicated.")
  void testThrowExceptionDuplicated() {
    assertThrows(
        IllegalArgumentException.class,
        () -> LotteryNumbers.of(new int[] {1, 1, 1, 1, 1, 1})
    );
  }
}
