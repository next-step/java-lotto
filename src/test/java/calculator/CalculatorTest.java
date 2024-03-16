package calculator;

import caculator.Calculator;
import caculator.domain.Number;
import caculator.domain.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
  private Calculator calculator;

  @BeforeEach
  void beforeEach() {
    calculator = new Calculator();
  }

  @Test
  void 문자열을_입력_받을_수_있다() {
    final String TEST_INPUT = "TEST";
    System.setIn(new ByteArrayInputStream(TEST_INPUT.getBytes()));
    assertThat(calculator.readInput()).isEqualTo("TEST");
  }

  @Test
  void 숫자부분만_추출() {
    final String input = "12 + 3 * 4 / 2";
    assertThat(calculator.extractOperands(input)).containsExactly(new Number(12), new Number(3), new Number(4), new Number(2));
  }

  @Test
  void 연산기호만_추출() {
    final String input = "5 + 8 * 40 / 2";
    assertThat(calculator.extractOperators(input)).containsExactly(Operator.PLUS, Operator.MULTIPLY, Operator.DIVIDE);
  }

  @Test
  void Numbers목록과_Operator목록을_가지고_수식_계산() {
    final List<Number> numbers = List.of(new Number(10), new Number(5), new Number(25), new Number(3), new Number(5));
    final List<Operator> operators = List.of(Operator.MULTIPLY, Operator.DIVIDE, Operator.PLUS, Operator.MINUS);
    assertThat(calculator.calculate(numbers, operators)).isEqualTo(0);
  }
}
