package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringCalculatorTest {

  @Test
  @DisplayName("입력값이 null 또는 empty String이면 결과는 0임을 검증하는 테스트")
  public void returnZeroWhenInputIsNullOrEmptyString() {
    assertAll(
            () -> assertThat(StringCalculator.splitAndSum(null)).isEqualTo(0),
            () -> assertThat(StringCalculator.splitAndSum("")).isEqualTo(0)
    );
  }

  @Test
  @DisplayName("입력값이 숫자 하나를 포함한 문자열이면, 결과는 입력값을 정수로 변환한 값과 같음을 검증하는 테스트")
  public void returnOriginWhenInputStringIsOneInteger() {
    // given
    String inputString = "1";
    int parsedInteger = Integer.parseInt(inputString);

    // when
    int result = StringCalculator.splitAndSum(inputString);

    // then
    assertThat(result).isEqualTo(parsedInteger);
  }

  @Test
  @DisplayName("입력값이 ','로 구분된 두 개의 숫자를 갖는 문자열이면, 결과는 두 수를 합친 값과 같음을 검증하는 테스트")
  public void sumTowIntegers() {
    // given
    String inputString = "1,2";
    int expected = 3;

    // when
    int result = StringCalculator.splitAndSum(inputString);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("입력값이 ',' 또는 ':'로 구분된 숫자들을 갖는 문자열이면, 결과는 모든 숫자를 합친 값과 같음을 검증하는 테스트")
  public void sumManyIntegersSplitedByDefaultDelimiters() {
    // given
    String inputString = "1,2:3";
    int expected = 6;

    // when
    int result = StringCalculator.splitAndSum(inputString);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("입력값이 //와 \n 문자 사이에 있는 커스텀 구분자로 구분된 숫자들을 갖는 문자열이면, " +
          "결과는 모든 숫자를 합친 값과 같음을 검증하는 테스트")
  public void sumManyIntegersSplitedByCustomDelimiter() {
    // given
    String inputString = "//;\n1;2;3";
    int expected = 6;

    // when
    int result = StringCalculator.splitAndSum(inputString);

    // then
    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("입력값이 ',' 또는 ':'로 구분된 음수포함 숫자들을 갖는 문자열이면, 결과는 모든 숫자를 합친 값과 같음을 검증하는 테스트")
  public void sumManyIntegersIncludeNegativeSplitedByDefaultDelimiters() {
    // given
    String inputString = "1,2:-3";
    int expected = 0;

    // when
    int result = StringCalculator.splitAndSum(inputString);

    // then
    assertThat(result).isEqualTo(expected);
  }

}
