package calculator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @DisplayName("null 입력 시 IllegalArgumentException을 반환한다.")
  @Test
  void inputNullThrowsException() {

    assertThatThrownBy(() -> {
      Calculator.calculate(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("빈문자열 입력 시 IllegalArgumentException을 반환한다.")
  @Test
  void inputNullStringThrowsException() {

    assertThatThrownBy(() -> {
      Calculator.calculate("");
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("두 숫자의 덧셈 연산이 잘 수행된다.")
  @Test
  void addCorrectly() {
    int result = Calculator.calculate("2 + 3");
    assertThat(result).isEqualTo(5);
  }

}