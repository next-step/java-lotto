package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void nullOrBlankThrowException() {
    Calculator calculator = new Calculator();
    assertAll(
        () -> assertThatThrownBy(
            () -> calculator.calculate("")
        ).isInstanceOf(IllegalArgumentException.class),
        () -> assertThatThrownBy(
            () -> calculator.calculate(null)
        ).isInstanceOf(IllegalArgumentException.class)
    );
  }
}