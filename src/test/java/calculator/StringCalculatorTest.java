package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  @Test
  public void 숫자가_하나가_들어왔을때에는_하나만_리턴한다() {
    String input = "3";
    assertThat(StringCalculator.calculate(input)).isEqualTo(3);
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {"", "  "})
  public void 입력값이_null_혹은_빈값일때_0을_리턴한다(String input) {
    assertThat(StringCalculator.calculate(input)).isEqualTo(0);
  }

}
