package calculator;

import calculator.domain.CalculatorQueue;
import calculator.domain.Operand;
import calculator.domain.Operator;
import calculator.domain.type.StringOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Queue;

import static calculator.domain.CalculatorQueue.CALCULATOR_INPUT_INCORRECT;
import static calculator.domain.Operand.ENTERED_NON_NUMERIC_VALUE;
import static calculator.domain.type.StringOperator.THIS_OPERATOR_IS_NOT_SUPPORTED;
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

  @Test
  @DisplayName("사칙 연산이 불가능한 입력 값인 경우 IllegalArgumentException throw")
  void inputTest2() {
    String given = "2 + 3 * 4 7";
    assertThatThrownBy(() -> CalculatorQueue.of(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(THIS_OPERATOR_IS_NOT_SUPPORTED, 7));
  }

  @ParameterizedTest
  @ValueSource(strings = {"2 + 3 * +", "2 + 3 * 4 * +"})
  @DisplayName("사칙 연산이 불가능한 입력 값인 경우 IllegalArgumentException throw")
  void inputTest3(String given) {
    assertThatThrownBy(() -> CalculatorQueue.of(given))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(String.format(ENTERED_NON_NUMERIC_VALUE, "+", given));
  }

  @Test
  @DisplayName("정상 입력 값 테스트")
  void inputTest4() {
    CalculatorQueue calculatorQueue = CalculatorQueue.of("2 + 3 * 4 / 2");
    assertThat(calculatorQueue.getOperands()).hasSize(4);
    assertThat(calculatorQueue.getOperators()).hasSize(3);
  }

  @Test
  @DisplayName("입력 값으로 들어온 사칙연산 기호를 순서대로 저장하는지 테스트")
  void inputTest5() {
    Queue<Operator> operators = CalculatorQueue.of("2 + 3 * 4 / 2").getOperators();
    assertThat(operators.poll()).isEqualTo(new Operator(StringOperator.ADDITION));
    assertThat(operators.poll()).isEqualTo(new Operator(StringOperator.MULTIPLICATION));
    assertThat(operators.poll()).isEqualTo(new Operator(StringOperator.DIVISION));
  }

  @Test
  @DisplayName("입력 값으로 들어온 숫자를 순서대로 저장하는지 테스트")
  void inputTest6() {
    Queue<Operand> operands = CalculatorQueue.of("2 + 3 * 4 / 7").getOperands();
    assertThat(operands.poll()).isEqualTo(new Operand(2));
    assertThat(operands.poll()).isEqualTo(new Operand(3));
    assertThat(operands.poll()).isEqualTo(new Operand(4));
    assertThat(operands.poll()).isEqualTo(new Operand(7));
  }
}