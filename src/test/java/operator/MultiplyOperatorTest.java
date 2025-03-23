package operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplyOperatorTest {

  @DisplayName("곱셈 테스트")
  @Test
  void testMultiplyOperator() {
    Operator operator = new MultiplyOperator();
    assertThat(operator.calculate(6, 3)).isEqualTo(18);
  }
}
