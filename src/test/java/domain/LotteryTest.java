package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LotteryTest {
  static List<int[]> lotteryNumberArrayProvider() {
    return List.of(
            new int[] {1, 2, 3, 4, 5},
            new int[] {1, 2, 3, 4, 5, 6, 7}
    );
  }

  @ParameterizedTest
  @MethodSource("lotteryNumberArrayProvider")
  void 입력된_숫자가_6개_아니면_생성_불가(int... numbers) {
    assertThatThrownBy(() -> Lottery.of(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Wrong number of lottery numbers!");
  }

  @Test
  void 당첨숫자에_대한_복권_결과() {
    final Lottery lottery = new Lottery(LotteryNumbers.of(1, 2, 3, 4, 5, 6));
    final LotteryNumbers lotteryNumbers = LotteryNumbers.of(1, 2, 3, 4, 5, 6);
    assertThat(lottery.result(lotteryNumbers)).isEqualTo(Result.of(PositiveNumber.of(6)));
  }

  @Test
  void 구매_가능한_복권_수() {
    PositiveNumber count = Lottery.count(PositiveNumber.of(1000));
    assertThat(count).isEqualTo(PositiveNumber.of(1));
  }
}
