import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  void givenEmpty_whenAdd_thenReturnZero(String sentence) {
    assertThat(StringCalculator.add(sentence)).isZero();
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

  @ParameterizedTest
  @ValueSource(strings = {"1,2,3", "1,2:3"})
  void givenSeparator(String sentence) {
    assertThat(StringCalculator.add(sentence)).isEqualTo(6);
  }

  @Test
  void givenCustomSeparator() {
    assertThat(StringCalculator.add("//;\n1;2;3")).isEqualTo(6);
  }
}
