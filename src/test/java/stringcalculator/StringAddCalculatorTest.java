package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

  @Test
  @DisplayName("올바르지 않는 input(null)")
  public void WithNullString() {
    int result = StringAddCalculator.splitAndSum(null);
    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("올바르지 않는 input(empty)")
  public void WithEmptyString() {
    int result = StringAddCalculator.splitAndSum("");
    assertThat(result).isEqualTo(0);
  }
}