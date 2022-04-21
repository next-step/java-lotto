package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  private StringCalculator stringCalculator;

  @BeforeEach
  void init() {
    stringCalculator = new StringCalculator();
  }

  @Test
  @DisplayName("덧셈 테스트")
  void addTest() {
    assertThat(stringCalculator.calculate("1 + 1")).isEqualTo(2);
  }
}
