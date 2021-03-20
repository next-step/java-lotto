package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
  @DisplayName("숫자 두 개가 쉼표를 구분자로 들어오면 두 숫자의 합을 반환한다.")
  void sumTwoNumbers() {
    assertAll(
        () -> assertThat(StringCalculator.sum("1,2")).isEqualTo(3),
        () -> assertThat(StringCalculator.sum("6,5")).isEqualTo(11)
    );
  }
}
