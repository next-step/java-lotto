package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLotteryNumbersTest {

  WinningLotteryNumbers winningLotteryNumbers;

  @BeforeEach
  void setup() {
    LotteryNumbers winningNumbers = new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    LotteryNumber bonusNumber = new LotteryNumber(7);
    winningLotteryNumbers = new WinningLotteryNumbers(winningNumbers, bonusNumber);
  }

  @ParameterizedTest
  @MethodSource(value = "generateWinningLottery")
  @DisplayName("Test win lotteries.")
  void testWinner(WinningLottery winning, LotteryNumbers bought) {
    assertEquals(winning, winningLotteryNumbers.rank(bought));
    assertEquals(winning.getMatchedCount(), winningLotteryNumbers.rank(bought).getMatchedCount());
    assertEquals(winning.getPrice(), winningLotteryNumbers.rank(bought).getPrice());
  }

  private static Stream<Arguments> generateWinningLottery() {
    return Stream.of(
        Arguments.of(WinningLottery.FIRST, new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
        Arguments.of(WinningLottery.SECOND, new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 7, 8))),
        Arguments.of(WinningLottery.THIRD, new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 5, 8))),
        Arguments.of(WinningLottery.FOURTH, new LotteryNumbers(Arrays.asList(1, 2, 3, 4, 8, 9))),
        Arguments.of(WinningLottery.FIFTH, new LotteryNumbers(Arrays.asList(1, 2, 3, 8, 9, 10))),
        Arguments.of(WinningLottery.NONE, new LotteryNumbers(Arrays.asList(1, 2, 8, 9, 10, 11)))
    );
  }
}
