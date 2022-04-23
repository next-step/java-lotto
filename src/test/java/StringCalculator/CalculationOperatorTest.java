package StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculationOperatorTest {

  @Test
  void addict_성공() {
    assertThat(Calculation.addict(1, 2)).isEqualTo(3);
  }

  @Test
  void subtract_성공() {
    assertThat(Calculation.subtract(1, 2)).isEqualTo(-1);
  }

  @Test
  void multiply_성공() {
    assertThat(Calculation.multiply(1, 2)).isEqualTo(2);
  }

  @Test
  void divide_성공() {
    assertThat(Calculation.divide(1, 2)).isEqualTo(0);
  }

  @Test
  void divide_실패() {
    assertThrows(IllegalArgumentException.class, () -> Calculation.divide(1, 0));
  }
}
