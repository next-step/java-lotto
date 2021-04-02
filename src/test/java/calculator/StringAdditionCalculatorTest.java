package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

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
  @NullAndEmptySource
  @DisplayName("빈 문자열 또는 null인 경우 0을 반환한다.")
  void operation_Should_zero_When_empty_or_blank_input(String emptyBlankStr) {
    // given

    // when
    int expected = StringAdditionCalculator.create(emptyBlankStr)
            .sum();

    // then
    assertThat(expected).isZero();
  }

  @ParameterizedTest
  @MethodSource(SUM_ARGUMENTS)
  @DisplayName("문자열 더하기 계산기")
  void sum(String input, int expected) {
    // given
    StringAdditionCalculator calculator = StringAdditionCalculator.create(input);

    // when
    int actual = calculator.sum();

    // then
    System.out.println("input " + input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  @DisplayName("문자열 입력값을 Integer 리스트로 반환")
  void stringToIntegerList() {
    // given
    String input = "1,2:3";

    // when
    List<Integer> numbers = StringAdditionCalculator.stringToIntegerList(input, new Delimiter(",|:"));

    // then
    assertThat(numbers)
            .isNotNull()
            .isNotEmpty()
            .hasSize(3)
            .containsExactlyElementsOf(Arrays.asList(1, 2, 3));
  }

  @Test
  @DisplayName("Integer 리스트로 반환 - 커스터마이징 구분자 사용")
  void stringToIntegerList_CustomSeparator() {
    // given
    String input = "//;\n1;2;3";

    // when
    Delimiter delimiter = Delimiter.createDelimiterRegexString(input);
    String numberString = StringAdditionCalculator.getNumberString(input);

    // then
    assertThat(StringAdditionCalculator.stringToIntegerList(numberString, delimiter))
            .isNotNull()
            .isNotEmpty()
            .hasSize(3)
            .containsExactlyElementsOf(Arrays.asList(1, 2, 3));
  }

  @ParameterizedTest
  @MethodSource(IS_POSITIVE_NUMBER_STRING_ARGUMENTS)
  void isPositiveNumberString(String input, boolean expected) {
    // given

    // when
    boolean actual = StringAdditionCalculator.isPositiveNumberString(input);

    // then
    assertThat(actual)
            .isEqualTo(expected);
  }


}
