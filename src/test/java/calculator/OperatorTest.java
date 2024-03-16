package calculator;

import caculator.domain.Number;
import caculator.domain.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorTest {
  @Test
  void PLUS는_덧셈() {
    Assertions.assertThat(Operator.PLUS.operate(new Number(1), new Number(2))).isEqualTo(new Number(3));
  }

  @Test
  void MINUS는_뺄셈() {
    Assertions.assertThat(Operator.MINUS.operate(new Number(20), new Number(5))).isEqualTo(new Number(15));
  }

  @Test
  void MULITPLY는_곱셈() {
    Assertions.assertThat(Operator.MULTIPLY.operate(new Number(10), new Number(3))).isEqualTo(new Number(30));
  }

  @Test
  void DIVIDE는_나눗셈() {
    Assertions.assertThat(Operator.DIVIDE.operate(new Number(100), new Number(2))).isEqualTo(new Number(50));
  }
}
