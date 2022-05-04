package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class OperandTest {

  @DisplayName("숫자 객체는 정수(양의 정수, 0, 음의 정수)로 구성된다")
  @ParameterizedTest
  @ValueSource(strings = {"-1", "0", "1"})
  void number(String value) {
    assertThatNoException().isThrownBy(() -> new Operand(value));
  }

  @DisplayName("문자 형태의 숫자를 전달받아 숫자 객체를 생성한다")
  @ParameterizedTest
  @CsvSource(value = {"-100:-100", "0:0", "100:100"}, delimiter = ':')
  void numberValue(String value, Integer expected) {
    assertThat(new Operand(value).number()).isEqualTo(expected);
  }

  @DisplayName("숫자 객체의 값을 반환한다")
  @ParameterizedTest
  @CsvSource(value = {"-1:-1", "0:0", "1:1"}, delimiter = ':')
  void value(String value, Integer expected) {
    assertThat(new Operand(value).number()).isEqualTo(expected);
  }

  @DisplayName("숫자형식이 아니면 NumberFormat 예외를 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"👍", "ab"})
  void constructorThrowsNumberFormatException(String input) {
    assertThatExceptionOfType(NumberFormatException.class).isThrownBy(
        () -> new Operand(input));
  }

  @DisplayName("null 또는 빈 문자열은 IllegalArgument 예외를 던진다")
  @ParameterizedTest
  @NullAndEmptySource
  void constructorThrowsIllegalArgumentException(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Operand(input));
  }

  @Test
  @DisplayName("숫자 객체를 0으로 나누는 경우 Arithmetic 예외를 던진다")
  void dividedByZero() {
    Operand one = new Operand("1");
    Operand zero = new Operand("0");
    assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> one.divide(zero));
  }

  @DisplayName("나눗셈")
  @ParameterizedTest
  @MethodSource(value = "provideStringsForDivide")
  void divide(Operand a, Operand b, Operand expected) {
    assertThat(a.divide(b)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideStringsForDivide() {
    return Stream.of(
        Arguments.of(new Operand("1"), new Operand("1"),
            new Operand("1")),
        Arguments.of(new Operand("1"), new Operand("-1"),
            new Operand("-1")),
        Arguments.of(new Operand("-1"), new Operand("2"),
            new Operand("0")),
        Arguments.of(new Operand("-1"), new Operand("-1"),
            new Operand("1")));
  }

  @DisplayName("덧셈")
  @ParameterizedTest
  @MethodSource(value = "provideStringsForAdd")
  void add(Operand a, Operand b, Operand expected) {
    assertThat(a.add(b)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideStringsForAdd() {
    return Stream.of(
        Arguments.of(new Operand("1"), new Operand("1"),
            new Operand("2")),
        Arguments.of(new Operand("1"), new Operand("-1"),
            new Operand("0")),
        Arguments.of(new Operand("-1"), new Operand("2"),
            new Operand("1")),
        Arguments.of(new Operand("-1"), new Operand("-1"),
            new Operand("-2")));
  }

  @DisplayName("뺄셈")
  @ParameterizedTest
  @MethodSource(value = "provideStringsForSubtract")
  void subtract(Operand a, Operand b, Operand expected) {
    assertThat(a.subtract(b)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideStringsForSubtract() {
    return Stream.of(
        Arguments.of(new Operand("1"), new Operand("1"),
            new Operand("0")),
        Arguments.of(new Operand("1"), new Operand("0"),
            new Operand("1")),
        Arguments.of(new Operand("-1"), new Operand("2"),
            new Operand("-3")),
        Arguments.of(new Operand("-1"), new Operand("-1"),
            new Operand("0")));
  }

  @DisplayName("곱셈")
  @ParameterizedTest
  @MethodSource(value = "provideStringsForMultiply")
  void multiply(Operand a, Operand b, Operand expected) {
    assertThat(a.multiply(b)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideStringsForMultiply() {
    return Stream.of(
        Arguments.of(new Operand("1"), new Operand("2"),
            new Operand("2")),
        Arguments.of(new Operand("1"), new Operand("0"),
            new Operand("0")),
        Arguments.of(new Operand("-1"), new Operand("2"),
            new Operand("-2")),
        Arguments.of(new Operand("-1"), new Operand("-1"),
            new Operand("1")));
  }
}