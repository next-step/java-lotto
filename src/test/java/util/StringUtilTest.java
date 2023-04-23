package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilTest {

  @ParameterizedTest
  @ValueSource(strings = {"-1", "-2", "0", "1", "2"})
  @DisplayName("StringUtils.isDigit() | 해당 문자가 정수 문자열이면 true 반환")
  void 정수형_문자열_판별_성공(String given) {
    // when
    boolean isDigit = StringUtils.isDigit(given);

    // then
    Assertions.assertThat(isDigit)
        .isTrue();
  }

  @ParameterizedTest
  @ValueSource(strings = {"+", "123+", " ", "-123+"})
  @DisplayName("StringUtils.isDigit() | 해당 문자가 정수 문자열이 아니면 false 반환")
  void 정수형_문자열_판별_실패(String given) {
    // when
    boolean isDigit = StringUtils.isDigit(given);

    // then
    Assertions.assertThat(isDigit)
        .isFalse();
  }

  @ParameterizedTest
  @ValueSource(strings = {"+", "-", "%", "*"})
  @DisplayName("StringUtils.isArithmeticOperator() | 해당 문자가 사칙연산 연산자이면 true 반환")
  void 사칙연산_연산자_판별_성공(String given) {
    // when
    boolean isArithmeticOperator = StringUtils.isArithmeticOperator(given);

    // then
    Assertions.assertThat(isArithmeticOperator)
        .isTrue();
  }


  @ParameterizedTest
  @ValueSource(strings = {"+-", "123+", " ", "-123+"})
  @DisplayName("StringUtils.isArithmeticOperator() | 해당 문자가 사칙연산 연산자가 아니면 false 반환")
  void 사칙연산_연산자_판별_실패(String given) {
    // when
    boolean isArithmeticOperator = StringUtils.isArithmeticOperator(given);

    // then
    Assertions.assertThat(isArithmeticOperator)
        .isFalse();
  }
}