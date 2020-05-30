package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlusCalculatorTest {

  @Test
  void calculate() {
    assertThat(new PlusCalculator().calculate(new String[]{"1", "2"})).isEqualTo(3);
  }
}