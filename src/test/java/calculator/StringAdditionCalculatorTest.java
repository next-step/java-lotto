package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static base.MethodSourceConstant.IS_POSITIVE_NUMBER_STRING_ARGUMENTS;
import static base.MethodSourceConstant.SUM_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAdditionCalculatorTest {

  @Test
  @DisplayName("문자열 더하기 계산기 객체 생성 테스트")
  void create() {
    // given
    StringAdditionCalculator calculator = StringAdditionCalculator.create("");

    // when

    // then
    assertThat(calculator).isNotNull();
  }

  @ParameterizedTest
  @MethodSource(IS_POSITIVE_NUMBER_STRING_ARGUMENTS)
  @DisplayName("입력값이 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다. ")
  void createError(String inputValue, boolean isPositiveNumber) {
    // given

    // when

    // then
    if (!isPositiveNumber) {
      assertThatThrownBy(() -> StringAdditionCalculator.create(inputValue)
              .sum())
              .isInstanceOf(RuntimeException.class);
    }
  }

  @ParameterizedTest
  @MethodSource(SUM_ARGUMENTS)
  @DisplayName("문자열 더하기 계산기")
  void sum(String input, int expected) {
    // given
    StringAdditionCalculator calculator = StringAdditionCalculator.create(input);

    // when
    Number actual = calculator.sum();

    // then
    assertThat(actual).isEqualTo(Number.create(expected));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("빈 문자열 또는 null인 경우 0을 반환한다.")
  void sum_blankStringInput(String emptyBlankStr) {
    // given

    // when
    Number expected = StringAdditionCalculator.create(emptyBlankStr)
            .sum();

    // then
    assertThat(expected).isEqualTo(Number.zero());
  }

}
