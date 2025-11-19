package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

  @ParameterizedTest
  @CsvSource({
      "+, 2, 3, 5",
      "-, 10, 3, 7",
      "*, 4, 5, 20",
      "/, 10, 2, 5"
  })
  void applyOperation(String symbol, int a, int b, int expected) {
    Operator operator = Operator.from(symbol);
    assertThat(operator.apply(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({
      "+, PLUS",
      "-, MINUS",
      "*, MULTIPLY",
      "/, DIVIDE"
  })
  void fromSymbol(String symbol, Operator expected) {
    assertThat(Operator.from(symbol)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({"&", "%", "^", "a", "1"})
  void invalidOperator(String invalidSymbol) {
    assertThatThrownBy(() -> Operator.from(invalidSymbol))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void plus() {
    assertThat(Operator.PLUS.apply(2, 3)).isEqualTo(5);
  }

  @Test
  void minus() {
    assertThat(Operator.MINUS.apply(10, 3)).isEqualTo(7);
  }

  @Test
  void multiply() {
    assertThat(Operator.MULTIPLY.apply(4, 5)).isEqualTo(20);
  }

  @Test
  void divide() {
    assertThat(Operator.DIVIDE.apply(10, 2)).isEqualTo(5);
  }
}

