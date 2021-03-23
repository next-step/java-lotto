package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallsTest {

  private LottoBalls lottoBalls;

  @BeforeEach
  void setUp() {
    lottoBalls = LottoBallFactory.initialize();
  }

  @DisplayName("공을 뽑으면 6개가 나와야 한다.")
  @Test
  void draw() {
    List<LottoBall> draw = lottoBalls.draw();
    assertThat(draw.size()).isEqualTo(6);
  }

}