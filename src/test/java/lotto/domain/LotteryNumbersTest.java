package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class  LotteryNumbersTest {

  LotteryNumbers winningNumbers;

  @BeforeEach
  void setup() {
    winningNumbers = new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("Test create.")
  void testCreate() {
    assertEquals(6, new LotteryNumbers().size());
  }

  @Test
  @DisplayName("Test not equals even if the numbers are the same.")
  void testNotEquals() {
    assertNotEquals(winningNumbers, new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
  }

  @Test
  @DisplayName("Test throw exception when the lottery's size is not 6.")
  void testThrowExceptionAboutSize() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
    );
  }

  @Test
  @DisplayName("Test throw exception when the number of lotteries are duplicated.")
  void testThrowExceptionDuplicated() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new LotteryNumbers(Arrays.asList(1, 1, 1, 1, 1, 1))
    );
  }
}
