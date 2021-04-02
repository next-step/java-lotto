package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static base.MethodSourceConstant.IS_POSITIVE_NUMBER_STRING_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

  @ParameterizedTest
  @MethodSource(IS_POSITIVE_NUMBER_STRING_ARGUMENTS)
  @DisplayName("Number 객체 생성")
  void create() {
    // given
    String str = "123";

    // when
    Number number = Number.positiveValueOf(str);

    // then
    assertThat(number)
            .isEqualTo(new Number(123));
  }

  @ParameterizedTest
  @MethodSource(IS_POSITIVE_NUMBER_STRING_ARGUMENTS)
  @DisplayName("입력값이 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다. ")
  void createError(String inputValue, boolean isPositiveNumber) {
    // given

    // when

    // then
    if (!isPositiveNumber) {
      assertThatThrownBy(() -> Number.positiveValueOf(inputValue))
              .isInstanceOf(RuntimeException.class);
    }
  }
}