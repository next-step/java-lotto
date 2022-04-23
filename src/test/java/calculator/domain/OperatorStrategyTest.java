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
  void operators(String operator, OperatorStrategy operatorStrategy) {
    OperatorStrategy strategy = OperatorStrategy.getStrategy(operator);

    assertThat(operatorStrategy).isEqualTo(strategy);
  }

  @Test
  @DisplayName("없는 연산자일 경우, 에러 발생 확인")
  void notExistOperator() {
    assertThatThrownBy(() -> {
      OperatorStrategy.getStrategy("x");
    }).isInstanceOf(InvalidOperatorException.class);
  }

}