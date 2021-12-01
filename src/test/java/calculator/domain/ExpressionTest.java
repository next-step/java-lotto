package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpressionTest {

  @Test
  @DisplayName("Test calculate with default delimiter.")
  public void testDefaultCalculate() {
    Expression expression = Expression.from("1,2,3");
    assertEquals(expression.calculate(), 6);
  }

  @Test
  @DisplayName("Test calculate with custom delimiter.")
  public void testCustomCalculate() {
    Expression expression = Expression.from("//..\n1..2..3");
    assertEquals(expression.calculate(), 6);
  }
}
