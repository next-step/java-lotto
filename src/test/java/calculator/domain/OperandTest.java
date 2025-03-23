package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OperandTest {

  @DisplayName("fromString 메서드는 문자열을 받아 피연산자로 변환한다")
  @Test
  void fromString() {
    Operand operand = Operand.fromString("3");
    assertThat(operand).isEqualTo(new Operand(3));
  }

  @DisplayName("toInt 메서드는 피연산자를 정수로 반환한다")
  @Test
  void toInt() {
    Operand operand = new Operand(3);
    assertThat(operand.toInt()).isEqualTo(3);
  }
}
