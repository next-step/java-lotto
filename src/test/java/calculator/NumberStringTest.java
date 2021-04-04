package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static base.MethodSourceConstant.NUMBER_STRING_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;

class NumberStringTest {

  @ParameterizedTest
  @MethodSource(NUMBER_STRING_ARGUMENTS)
  @DisplayName("입력 문자열 값에 숫자 문자열 객체 생성")
  void generateNumberString(String input, String expected) {
    // given

    // when
    NumberString numberString = NumberString.generateNumberString(input);

    // then
    assertThat(numberString)
            .isEqualTo(NumberString.create(expected));
  }
}