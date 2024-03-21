package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoBallsTest {
  @Test
  void 몇_개_일치하는지_반환() {
    Assertions.assertThat(LottoBalls.of(1, 2, 3, 4, 5, 6).matchCount(LottoBalls.of(1, 2, 3, 4, 5, 6)))
            .isEqualTo(PositiveNumber.of(6));
  }
}