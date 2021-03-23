package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBallTest {

  @DisplayName("숫자가 0인 공은 공은 생성 불가")
  @Test
  void zero_ball_number() {
    assertThatThrownBy( () -> LottoBall.create(0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또공 생성가능한 숫자가 아닙니다.");
  }

  @DisplayName("45보다 큰 공은 생성 불")
  @Test
  void ball_number_exception() {
    assertThatThrownBy( () -> LottoBall.create(46))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또공 생성가능한 숫자가 아닙니다.");
  }

}
