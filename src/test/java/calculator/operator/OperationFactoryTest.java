package calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationFactoryTest {

  @DisplayName("더하기 연산자 반환 테스트")
  @Test
  public void testGetAddOperator() {
    Operator operator = OperationFactory.getOperator("+");
    assertInstanceOf(AddOperator.class, operator);
  }

  @DisplayName("빼기 연산자 반환 테스트")
  @Test
  public void testGetSubtractOperator() {
    Operator operator = OperationFactory.getOperator("-");
    assertInstanceOf(SubtractOperator.class, operator);
  }

  @DisplayName("곱셈 연산자 반환 테스트")
  @Test
  public void testGetMultiplyOperator() {
    Operator operator = OperationFactory.getOperator("*");
    assertInstanceOf(MultiplyOperator.class, operator);
  }

  @DisplayName("나누기 연산자 반환 테스트")
  @Test
  public void testGetDivideOperator() {
    Operator operator = OperationFactory.getOperator("/");
    assertInstanceOf(DivideOperator.class, operator);
  }

  @DisplayName("유효하지 않은 연산자 반환 테스트")
  @Test
  public void testGetInvalidOperator() {
    assertThrows(RuntimeException.class, () -> OperationFactory.getOperator("%"));
  }
}
