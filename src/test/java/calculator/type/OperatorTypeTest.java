package calculator.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTypeTest {

  @DisplayName("덧셈 연산기 가져오기")
  @Test
  public void testGetAddOperatorType() {
    OperatorType operator = OperatorType.fromSymbol("+");
    assertThat(operator).isEqualTo(OperatorType.ADD);
  }

  @DisplayName("뺄셈 연산기 타입 가져오기")
  @Test
  public void testSubtractOperatorType() {
    OperatorType operator = OperatorType.fromSymbol("-");
    assertThat(operator).isEqualTo(OperatorType.SUBTRACT);
  }

  @DisplayName("곱셈 연산기 타입 가져오기")
  @Test
  public void testMultiplyOperatorType() {
    OperatorType operator = OperatorType.fromSymbol("*");
    assertThat(operator).isEqualTo(OperatorType.MULTIPLY);
  }

  @DisplayName("나눗셈 연산기 타입 가져오기")
  @Test
  public void testDivideOperatorType() {
    OperatorType operator = OperatorType.fromSymbol("/");
    assertThat(operator).isEqualTo(OperatorType.DIVIDE);
  }

  @DisplayName("유요하지 않은 연산기 타입 가져오기")
  @Test
  public void testInvalidSymbolOperatorType() {
    assertThrows(IllegalArgumentException.class, () -> OperatorType.fromSymbol("x"));
  }
}
