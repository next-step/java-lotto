package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class StringCalculatorTest {

  @DisplayName("계산기 동작 테스트")
  @Test
  void testRun() {
    assertThat(StringCalculator.run("2 + 3 * 4 / 2")).isEqualTo(10);
  }
}
