package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LotteryTest {
  @Test
  void 몇_개_일치하는지_반환() {
    Lottery lottery = Lottery.of(LottoBall.of(8), LottoBalls.of(1, 2, 3, 4, 5, 6));
    Assertions.assertThat(lottery.matchCount(LottoBalls.of(1, 2, 3, 4, 5, 6)))
            .isEqualTo(PositiveNumber.of(6));
  }
}
