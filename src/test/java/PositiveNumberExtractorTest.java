import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringaddcalculator.PositiveNumber;
import stringaddcalculator.PositiveNumberExtractor;
import stringaddcalculator.StringAddCalculator;

public class PositiveNumberExtractorTest {

  @DisplayName("음수가 입력된 경우 RuntimeException을 뱉는다.")
  @Test
  void 음수인_경우_생성되지_않는다() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> {
          PositiveNumberExtractor.create("-10").get(0);
        });
  }

  @DisplayName("NULL 또는 빈 문자열이 입력된 경우 0을 뱉는다.")
  @NullAndEmptySource
  @ParameterizedTest
  void NULL_빈_문자열이_입력된_경우_0을_뱉는다(String value) {
    List<PositiveNumber> positiveNumber = PositiveNumberExtractor.create(value);
    assertThat(positiveNumber.get(0).getNumber()).isEqualTo(0);
  }

  @DisplayName("입력받은 값이 변환 불가능한 경우 RuntimeException을 뱉는다.")
  @CsvSource({"*3", "&6", "$32"})
  @ParameterizedTest
  void 정수로_변경_불가하면_생성되지_않는다(String value) {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> PositiveNumberExtractor.create(value));
  }

  @DisplayName("하나만 입력된 자기 자신의 양수의 경우 정상적으로 출력된다.")
  @Test
  void 양수인_경우_생성된다() {
    String testNumber = "5";
    List<PositiveNumber> positiveNumber = PositiveNumberExtractor.create(testNumber);
    assertThat(positiveNumber.get(0).getNumber()).isEqualTo(Integer.parseInt(testNumber));
  }

  @DisplayName("구분자가 컴마로 구성된 문자열이 입력될 경우 이를 합한 숫자가 반환된다.")
  @CsvSource(value = {"3,4! 7", "5,6! 11", "5,6,7! 18"}, delimiter = '!')
  @ParameterizedTest
  void 컴마로_구성된_문자열의_합이_리턴된다(String value, Integer result) {
    List<PositiveNumber> positiveNumbers = PositiveNumberExtractor.create(value);
    assertThat(StringAddCalculator.sum(positiveNumbers)).isEqualTo(result);
  }

  @DisplayName("구분자가 콜론으로 구성된 문자열이 입력될 경우 이를 합한 숫자가 반환된다.")
  @CsvSource(value = {"3:4! 7", "5:6! 11", "5:6:7! 18"}, delimiter = '!')
  @ParameterizedTest
  void 콜론으로_구성된_문자열의_합이_리턴된다(String value, Integer result) {
    List<PositiveNumber> positiveNumbers = PositiveNumberExtractor.create(value);
    assertThat(StringAddCalculator.sum(positiveNumbers)).isEqualTo(result);
  }
}
