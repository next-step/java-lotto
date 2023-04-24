package stringcalculator.domain.operator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

  @DisplayName("사칙연산을 수행한다.")
  @Test
  public void operate() {
    Operator addOperator = new AddOperator();
    Operator subtractOperator = new SubtractOperator();
    Operator multiplyOperator = new MultiplyOperator();
    Operator divideOperator = new DivideOperator();

    assertThat(addOperator.operate(1, 1)).isEqualTo(2);
    assertThat(subtractOperator.operate(1, 1)).isEqualTo(0);
    assertThat(multiplyOperator.operate(1, 1)).isEqualTo(1);
    assertThat(divideOperator.operate(1, 1)).isEqualTo(1);
  }
}
