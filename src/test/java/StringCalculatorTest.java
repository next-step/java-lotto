import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  void givenEmpty_whenAdd_thenReturnZero(String value) {
    assertThat(StringCalculator.add(value)).isZero();
  }

  @DisplayName("문자열 숫자 하나만 입력")
  @Test
  void givenOneNumberAsString() {
    assertThat(StringCalculator.add("4")).isEqualTo(4);
  }

  @Test
  void givenCommaSeparator() {
    assertThat(StringCalculator.add("1,2")).isEqualTo(3);
  }

  @Test
  void givenColonSeparator() {
    assertThat(StringCalculator.add("1:2")).isEqualTo(3);
  }
}
