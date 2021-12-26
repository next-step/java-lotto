package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

  @ParameterizedTest
  @MethodSource(value = "generateWinningLottery")
  @DisplayName("Test win lotteries.")
  void testThirdWinner(WinningLottery winning, LotteryNumbers bought) {
    assertEquals(winning.getMatchedCount(), bought.rank(winningNumbers).getMatchedCount());
    assertEquals(winning.getPrice(), bought.rank(winningNumbers).getPrice());
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

  private static Stream<Arguments> generateWinningLottery() {
    return Stream.of(
        Arguments.of(WinningLottery.FIRST, new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
        Arguments.of(WinningLottery.SECOND, new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 7))),
        Arguments.of(WinningLottery.THIRD, new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 7, 8))),
        Arguments.of(WinningLottery.FOURTH, new LotteryNumbers(Arrays.asList(1, 2, 3, 7, 8, 9))),
        Arguments.of(WinningLottery.NONE, new LotteryNumbers(Arrays.asList(1, 2, 7, 8, 9, 10)))
    );
  }
}
