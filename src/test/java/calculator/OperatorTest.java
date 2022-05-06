package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("사칙 연산자 검증")
public class OperatorTest {

  @DisplayName("매개변수로 받은 숫자 객체 값이 null인 경우 NullPoint 예외를 던진다")
  @ParameterizedTest
  @NullSource
  void throwNullPointException(String value) {
    assertThatNullPointerException().isThrownBy(() -> Operator.valueOf(value));
  }

  @DisplayName("매개변수로 받은 숫자 객체 값이 빈 공백 문자일 경우 IllegalArgument 예외를 던진다")
  @ParameterizedTest
  @EmptySource
  void throwIllegalArgumentException(String value) {
    assertThatIllegalArgumentException().isThrownBy(() -> Operator.valueOf(value));
  }

  @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgument 예외를 던진다")
  @ParameterizedTest
  @ValueSource(strings = {"=", "!", "@", "🥲", "a", "1"})
  void notOperatorSignThrowsIllegalArgumentException(String invalidSign) {
    assertThatIllegalArgumentException().isThrownBy(() -> Operator.find(invalidSign))
        .withMessageMatching(".\\s+?는 지원하지 않는 기호입니다.?");
  }

  @DisplayName("연산자 객체는 +, -, *, / 로 구성된다")
  @ParameterizedTest
  @ValueSource(strings = {"+", "-", "*", "/"})
  void operatorTypes(String sign) {
    assertThatNoException().isThrownBy(() -> Operator.find(sign));
  }

  @DisplayName("덧셈 연산자는 숫자 객체 2개를 인자로 받아 두 객체를 더한 결과를 반환한다")
  @Test
  void add() {
    Operand a = new Operand("1");
    Operand b = new Operand("2");
    Operand result = new Operand("3");
    assertThat(Operator.operate("+", a, b)).isEqualTo(result);
  }

  @DisplayName("뺄셈 연산자는 숫자 객체 2개를 인자로 받아 두 객체를 더한 뺀 반환한다")
  @Test
  void subtract() {
    Operand a = new Operand("1");
    Operand b = new Operand("2");
    Operand result = new Operand("-1");
    assertThat(Operator.operate("-", a, b)).isEqualTo(result);
  }

  @DisplayName("곱셈 연산자는 숫자 객체 2개를 인자로 받아 두 객체를 곱한 결과를 반환한다")
  @Test
  void multiply() {
    Operand a = new Operand("1");
    Operand b = new Operand("2");
    Operand result = new Operand("2");
    assertThat(Operator.operate("*", a, b)).isEqualTo(result);
  }

  @DisplayName("나눗셈 연산자는 숫자 객체 2개를 인자로 받아 두 객체를 나눈 결과를 반환한다")
  @Test
  void divide() {
    Operand a = new Operand("2");
    Operand b = new Operand("1");
    Operand result = new Operand("2");
    assertThat(Operator.operate("/", a, b)).isEqualTo(result);
  }
}
