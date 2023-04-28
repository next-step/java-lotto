package study.stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

  @DisplayName("사칙연산을 수행한다.")
  @Test
  public void operate() {
    assertThat(Operator.ADD.operate(1, 1)).isEqualTo(2);
    assertThat(Operator.SUBTRACT.operate(1, 1)).isEqualTo(0);
    assertThat(Operator.MULTIPLY.operate(1, 1)).isEqualTo(1);
    assertThat(Operator.DIVIDE.operate(1, 1)).isEqualTo(1);
  }
}
