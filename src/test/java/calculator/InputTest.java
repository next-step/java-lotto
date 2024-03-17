package calculator;

import calculator.domain.CalculatorQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.domain.CalculatorQueue.CALCULATOR_INPUT_INCORRECT;
import static calculator.domain.CalculatorQueue.INPUT_ORDER_INCORRECT;
import static org.assertj.core.api.Assertions.*;

public class InputTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
  void inputTest(String given) {
    assertThatThrownBy(() -> CalculatorQueue.of(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(CALCULATOR_INPUT_INCORRECT, given));
  }

  @ParameterizedTest
  @ValueSource(strings = {"2 + 3 * 4 7", "2 + 3 * 4 / +"})
  @DisplayName("사칙 연산이 불가능한 입력 값인 경우 IllegalArgumentException throw")
  void inputTest2(String given) {
    assertThatThrownBy(() -> CalculatorQueue.of(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(INPUT_ORDER_INCORRECT, given));
  }

  @Test
  @DisplayName("정상 입력 값 테스트")
  void inputTest3() {
    CalculatorQueue calculatorQueue = CalculatorQueue.of("2 + 3 * 4 / 2");
    assertThat(calculatorQueue.getNumbers()).hasSize(4);
    assertThat(calculatorQueue.getOperators()).hasSize(3);
  }
}