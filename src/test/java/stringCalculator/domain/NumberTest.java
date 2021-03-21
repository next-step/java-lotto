package stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

  @DisplayName("빈문자열은 0으로 인식한다.")
  @Test
  void empty() {
    assertThat(new Number("")).isEqualTo(new Number("0"));
  }

  @DisplayName("null은 0으로 인식한다.")
  @Test
  void null_test() {
    assertThat(new Number(null)).isEqualTo(new Number("0"));
  }

  @DisplayName("음수면 예외 발생")
  @Test
  void negative_throw_exception() {
    assertThatThrownBy( () -> new Number("-1")).isInstanceOf(RuntimeException.class);
  }

}