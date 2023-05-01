package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void 계산기_정상_테스트() {
    Numbers numbers = new Numbers("1","2","3");
    Operators operators = new Operators("*", "+");

    Calculator calculator = new Calculator(numbers, operators);

    int result = calculator.calculate();

    assertThat(result).isEqualTo(5);
  }
}