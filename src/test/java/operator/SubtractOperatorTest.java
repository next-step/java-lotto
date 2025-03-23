package operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractOperatorTest {

  @DisplayName("빼기 테스트")
  @Test
  void testSubtractOperator() {
    Operator operator = new SubtractOperator();
    assertThat(operator.calculate(6, 3)).isEqualTo(18);
  }
}
