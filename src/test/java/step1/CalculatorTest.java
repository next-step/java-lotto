package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.exception.AdderException;

class CalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  void null_or_empty_string이_오면_0_반환(String string) {
    assertThat(Calculator.calculate(string)).isEqualTo(0);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "3"})
  void 숫자_하나를_입력_해당_숫자를_반환(String string) {
    assertThat(Calculator.calculate(string)).isEqualTo(Integer.parseInt(string));
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,3=6", "4:5:6=15", "7:8,9=24"}, delimiter = '=')
  void 쉼표_콜론으로_구분된_문자열을_구분자로_분리_후_합을_반환(String input, int result) {
    assertThat(Calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"//!\\n1!2!3=6", "//@\\n4@5@6=15"}, delimiter = '=')
  void 커스텀_구분자를_포함한_문자열을_커스텀_구분자로_분리_후_합을_반환(String input, int result) {
    assertThat(Calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @ValueSource(strings = {"//;\\n1;a;3", "//@\\n4@-5@8", "a,b,c", "-1,1"})
  void 숫자가_아닌_것_과_음수를_더하면_AdderException(String input) {
    assertThrows(AdderException.class, () -> Calculator.calculate(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"testtest", "fef:3", "a:1\\n", "//;\\n;;"})
  void 포맷에_맞지_않는_값을_더하면_AdderException(String input) {
    assertThrows(AdderException.class, () -> Calculator.calculate(input));
  }
}