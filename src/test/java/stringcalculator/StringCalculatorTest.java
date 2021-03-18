package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  @Test
  @DisplayName("빈 문자열, null이 들어오면 0을 반환한다.")
  void calculateEmtpyAndNull() {
    assertAll(
        () -> assertThat(StringCalculator.sum(null)).isEqualTo(0),
        () -> assertThat(StringCalculator.sum("")).isEqualTo(0)
    );
  }
}
