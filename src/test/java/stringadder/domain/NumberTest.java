package stringadder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringadder.domain.Number.fromString;

class NumberTest {

  @DisplayName("객체 생성 테스트")
  @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
  @ParameterizedTest
  void testConstruct(String stringInput, int intInput) {
    assertThat(fromString(stringInput)).isEqualTo(new Number(intInput));
  }

  @DisplayName("음수, 정수가 아닌 숫자, 숫자가 아닌 값이 들어오면 IllegalArgumentException 던짐")
  @ValueSource(strings = {"-1", "1.23", "a"})
  @ParameterizedTest
  void failTestConstruct(String stringInput) {
    assertThatThrownBy(() -> fromString(stringInput)).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("두 가지 Number 객체를 sum하면 숫자 값을 더한 값을 가진 새로운 number 객체 반환")
  @CsvSource(value = {"1:2:3", "2:4:6"}, delimiter = ':')
  @ParameterizedTest
  void testSum(String one, String theOther, String result) {
    assertThat(Number.sum(fromString(one), fromString(theOther))).isEqualTo(fromString(result));
  }
}
