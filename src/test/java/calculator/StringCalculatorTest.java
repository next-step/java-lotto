package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  @Test
  public void 숫자가_하나가_들어왔을때에는_하나만_리턴한다() {
    String input = "3";
    assertThat(StringCalculator.calculate(input)).isEqualTo(input);
  }

}
