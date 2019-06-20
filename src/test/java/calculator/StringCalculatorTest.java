package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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


  @ParameterizedTest
  @CsvSource(value = {"1,2$3", "1,2,3$6", "1,2:3$6"}, delimiter = '$')
  public void 콤마와_콜론으로_인풋값을_분리한_값의_합을리턴한다(String input,int result) {
    assertThat(StringCalculator.calculate(input)).isEqualTo(result);
  }

  @Test
  public void 커스텀_구분자로_분리한후_합을리턴한다() {
    String input="//;\n1;2;3";
    assertThat(StringCalculator.calculate(input)).isEqualTo(6);
  }

  @ParameterizedTest
  @CsvSource(value = {"//;\\n1;2;3$true" , "1,2$false"}, delimiter = '$')
  public void 커스텀식이지확인(String input,boolean result) {
    assertThat(CustomSeparator.isCustomSeparatorCase(input)).isEqualTo(result);
  }


}
