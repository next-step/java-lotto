package StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculationOperatorTest {

  @Test
  void addict_성공() {
    assertThat(CalculationOperator.addict(1, 2)).isEqualTo(3);
  }

  @Test
  void subtract_성공() {
    assertThat(CalculationOperator.subtract(1, 2)).isEqualTo(-1);
  }

  @Test
  void multiply_성공() {
    assertThat(CalculationOperator.multiply(1, 2)).isEqualTo(2);
  }

  @Test
  void divide_성공() {
    assertThat(CalculationOperator.divide(1, 2)).isEqualTo(0);
  }

  @Test
  void divide_실패() {
    assertThrows(IllegalArgumentException.class, () -> CalculationOperator.divide(1, 0));
  }
}
