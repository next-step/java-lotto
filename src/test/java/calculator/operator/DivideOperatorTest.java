package calculator.operator;

import calculator.operator.DivideOperator;
import calculator.operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DivideOperatorTest {

  @DisplayName("나눗셈 테스트")
  @Test
  void testDivedOperator() {
    Operator operator = new DivideOperator();
    assertThat(operator.calculate(6, 4)).isEqualTo(1);
  }

}
