package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBallTest {

  @DisplayName("숫자가 0인 공은 공은 생성 불가")
  @Test
  void zero_ball_number() {
    assertThatThrownBy(() -> new LottoBall(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또공 생성가능한 숫자가 아닙니다.");
  }

  @DisplayName("45보다 큰 공은 생성 불")
  @Test
  void ball_number_exception() {
    assertThatThrownBy(() -> new LottoBall(46))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또공 생성가능한 숫자가 아닙니다.");
  }

  @DisplayName("서로다른 6개의 공을 뽑아야 한다.")
  @Test
  void draw() {
    List<LottoBall> drawResult = LottoBall.draw();
    assertThat(drawResult.size()).isEqualTo(6);
    assertThat(drawResult).doesNotHaveDuplicates();
  }

}
