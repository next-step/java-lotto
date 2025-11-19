package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExpressionTest {

  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {
      "10,-,3,*,/",
      "*,3",
      "1,*,3,/"
  })
  void isInvalidFormat(String expression) {
    List<String> tokens = Arrays.stream(expression.split(",")).toList();
    assertThatThrownBy(() -> new Expression(tokens)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void calculateComplexExpression() {
    List<String> tokens = List.of("2", "+", "3", "*", "4", "-", "10", "/", "1");
    Expression expression = new Expression(tokens);
    assertThat(expression.calculate()).isEqualTo(10);
  }

}