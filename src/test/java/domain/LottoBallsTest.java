package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoBallsTest {
  @Test
  void n_번째_요소가_일치하는지_확인() {
    Assertions.assertThat(LottoBalls.of(1, 2, 3, 4, 5, 6).match(PositiveNumber.of(1), LottoBalls.of(1, 2, 3, 4, 5, 6)))
            .isTrue();
  }
}