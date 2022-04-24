package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.InvalidOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorStrategyTest {

  @ParameterizedTest
  @DisplayName("연산자에 맞는 operatorStrategy 를 반환하는지 확인")
  @CsvSource(value = {"+|PLUS", "-|MINUS", "*|MULTIPLY", "/|DIVIDE"}, delimiter = '|')
  void operators(String operatorStr, Operator operatorExpected) {
    Operator operator = Operator.getOperator(operatorStr);

    assertThat(operator).isEqualTo(operatorExpected);
  }

  @Test
  @DisplayName("없는 연산자일 경우, 에러 발생 확인")
  void notExistOperator() {
    assertThatThrownBy(() -> {
      Operator.getOperator("x");
    }).isInstanceOf(InvalidOperatorException.class);
  }

  @Test
  @DisplayName("덧셈 연산자 결과 확인")
  void plus() {
    Number number1 = new Number("100");
    Number number2 = new Number("200");
    Operator operator = Operator.getOperator("+");

    assertThat(operator.operate(number1, number2)).usingRecursiveComparison()
        .isEqualTo(new Number(300));
  }

  @Test
  @DisplayName("뺄셈 연산자 결과 확인")
  void minus() {
    Number number1 = new Number("100");
    Number number2 = new Number("200");
    Operator operator = Operator.getOperator("-");

    assertThat(operator.operate(number1, number2)).usingRecursiveComparison()
        .isEqualTo(new Number(-100));
  }

  @Test
  @DisplayName("곱셈 연산자 결과 확인")
  void multiply() {
    Number number1 = new Number("100");
    Number number2 = new Number("200");
    Operator operator = Operator.getOperator("*");

    assertThat(operator.operate(number1, number2)).usingRecursiveComparison()
        .isEqualTo(new Number(20000));
  }

  @Test
  @DisplayName("나눗셈 연산자 결과 확인")
  void divide() {
    Number number1 = new Number("100");
    Number number2 = new Number("100");
    Operator operator = Operator.getOperator("/");

    assertThat(operator.operate(number1, number2)).usingRecursiveComparison()
        .isEqualTo(new Number(1));
  }

}