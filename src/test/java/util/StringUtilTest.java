package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilTest {

  @DisplayName("StringUtils.isDigit() | 해당 문자가 정수 문자열이면 true 반환")
  @ParameterizedTest(name = "정수: {0}")
  @ValueSource(strings = {"-1", "-2", "0", "1", "2"})
  void 정수형_문자열_판별_성공(String given) {
    // when
    boolean isDigit = StringUtils.isDigit(given);

    // then
    Assertions.assertThat(isDigit)
        .isTrue();
  }

  @DisplayName("StringUtils.isDigit() | 해당 문자가 정수 문자열이 아니면 false 반환")
  @ParameterizedTest(name = "정수 문자열이 아닌 문자열: {0}")
  @ValueSource(strings = {"+", "123+", " ", "-123+"})
  void 정수형_문자열_판별_실패(String given) {
    // when
    boolean isDigit = StringUtils.isDigit(given);

    // then
    Assertions.assertThat(isDigit)
        .isFalse();
  }

  @DisplayName("StringUtils.isArithmeticOperator() | 해당 문자가 사칙연산 연산자이면 true 반환")
  @ParameterizedTest(name = "연산자: {0}")
  @ValueSource(strings = {"+", "-", "%", "*"})
  void 사칙연산_연산자_판별_성공(String given) {
    // when
    boolean isArithmeticOperator = StringUtils.isArithmeticOperator(given);

    // then
    Assertions.assertThat(isArithmeticOperator)
        .isTrue();
  }

  @DisplayName("StringUtils.isArithmeticOperator() | 해당 문자가 사칙연산 연산자가 아니면 false 반환")
  @ParameterizedTest(name = "사칙연산 연산자가 아닌 문자: {0}")
  @ValueSource(strings = {"+-", "123+", " ", "-123+"})
  void 사칙연산_연산자_판별_실패(String given) {
    // when
    boolean isArithmeticOperator = StringUtils.isArithmeticOperator(given);

    // then
    Assertions.assertThat(isArithmeticOperator)
        .isFalse();
  }

  @DisplayName("StringUtils.isBlank() | 문자열이 null 이나 empty string 이면 true 반환")
  @ParameterizedTest(name = "문자: {0}")
  @NullAndEmptySource
  void 비어있는_문자_판별 (String given) {
    // when
    boolean isStringBlank = StringUtils.isBlank(given);

    // then
    Assertions.assertThat(isStringBlank)
        .isTrue();
  }

  @DisplayName("StringUtils.isNotBlank() | 문자열이 null 이나 empty string 이면 false 반환")
  @ParameterizedTest(name = "문자: {0}")
  @NullAndEmptySource
  void 비어있지_않은_문자_판별 (String given) {
    // when
    boolean isStringBlank = StringUtils.isNotBlank(given);

    // then
    Assertions.assertThat(isStringBlank)
        .isFalse();
  }
}