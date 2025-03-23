package calculator.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ExpressionUnitTest {

  @DisplayName("생성자 테스트")
  @Test
  public void testConstructor1() {
    assertDoesNotThrow(() -> ExpressionUnit.valueOf(OperatorType.ADD, 3));
  }
}
