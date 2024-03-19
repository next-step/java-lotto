package calculator;

import caculator.domain.Number;
import caculator.domain.Operator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
  @ParameterizedTest
  @CsvSource(value = {"2:4:PLUS:6", "12:3:MINUS:9", "10:5:MULTIPLY:50", "30:5:DIVIDE:6"}, delimiter = ':')
  void 연산자와_피연산자를_입력받아_연산결과를_반환(int input1, int input2, Operator input3, int expected) {
    Number op1 = new Number(input1);
    Number op2 = new Number(input2);
    assertThat(op1.apply(input3, op2)).isEqualTo(new Number(expected));
  }
}
