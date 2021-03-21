package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

  @Test
  @DisplayName("빈 문자열, null이 들어오면 0을 반환한다.")
  void calculateEmptyAndNull() {
    assertAll(
        () -> assertThat(StringCalculator.sum(null)).isEqualTo(0),
        () -> assertThat(StringCalculator.sum("")).isEqualTo(0)
    );
  }

  @Test
  @DisplayName("숫자 형태의 문자열이 들어오면 해당 숫자를 반환한다.")
  void calculateNumber() {
    assertAll(
        () -> assertThat(StringCalculator.sum("1")).isEqualTo(1),
        () -> assertThat(StringCalculator.sum("2")).isEqualTo(2)
    );
  }

  @Test
  @DisplayName("숫자 두 개, 쉼표를 구분자로 두 숫자의 합을 반환한다.")
  void sumTwoNumbers() {
    assertAll(
        () -> assertThat(StringCalculator.sum("1,2")).isEqualTo(3),
        () -> assertThat(StringCalculator.sum("6,5")).isEqualTo(11)
    );
  }

  @Test
  @DisplayName("숫자 세 개, 쉼표과 콜론를 구분자로 세 숫자의 합을 반환한다.")
  void sumThreeNumbers() {
    assertAll(
        () -> assertThat(StringCalculator.sum("1,2:3")).isEqualTo(6),
        () -> assertThat(StringCalculator.sum("6,5:2")).isEqualTo(13)
    );
  }

  @Test
  @DisplayName("숫자 두 개, 커스텀 구분자로 두 숫자의 합을 반환한다.")
  void sumTwoNumbersWithCustomDelimiter() {
    assertAll(
        () -> assertThat(StringCalculator.sum("//;\n1;2")).isEqualTo(3),
        () -> assertThat(StringCalculator.sum("//$\n10$5")).isEqualTo(15)
    );
  }

  @ParameterizedTest
  @DisplayName("음수가 입력되었을 때, NegativeNumberException 이 발생해야 한다.")
  @ValueSource(strings = {"1,-2", "-6,5,3"})
  void sumNegativeNumber(String expression) {
    assertThatThrownBy(
        () -> StringCalculator.sum(expression)
    ).isInstanceOf(NegativeNumberException.class);
  }
}
