package calculator.operator;

import calculator.operator.AddOperator;
import calculator.operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddOperatorTest {

  @DisplayName("덧셈 테스트")
  @Test
  void testAddOperator() {
    Operator operator = new AddOperator();
    assertThat(operator.calculate(1, 2)).isEqualTo(3);
  }

}
