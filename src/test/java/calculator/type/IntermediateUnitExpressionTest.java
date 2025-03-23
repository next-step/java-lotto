package calculator.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class IntermediateUnitExpressionTest {

  @DisplayName("생성자 테스트")
  @Test
  public void testConstructor1() {
    assertDoesNotThrow(() -> IntermediateUnitExpression.valueOf(OperatorType.ADD, 3));
  }
}
