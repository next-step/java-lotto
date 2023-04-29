package calculator;

import calculator.domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

  Calculator 계산기;

  @BeforeEach
  void setup() {
    계산기 = new Calculator();
  }

  @Test
  @DisplayName("Calculator | 나눗셈의 결과는 정수부분만 반환한다")
  public void 나눗셈_결과는_정수부분만_반환 () {

    // given
    final String 계산식 = "10 % 3";

    // when
    int 결과 = 계산기.calculate(계산식);

    // then
    Assertions.assertThat(결과)
        .isEqualTo(3);
  }

  @DisplayName("Calculator | null 이거나 empty string 인 식은 계산 할 수 없다.")
  @ParameterizedTest(name = "입력값 : {0}")
  @ValueSource(strings = {" ", ""})
  @NullSource
  public void null_또는_empty_string은_계산_불가 (String given) {
    // when && then
    Assertions.assertThatThrownBy(() -> 계산기.calculate(given))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Calculator | 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다")
  @Test
  public void 사칙연산_순서가_아닌_입력순으로_계산 () {
    // given
    final String 입력 = "1 + 2 * 3 - 4 % 1";

    // when && then
    int 결과 = 계산기.calculate(입력);

    // then
    Assertions.assertThat(결과)
        .isEqualTo(5);
  }

  @DisplayName("Calculator | 문자열 계산기에서는 0으로 나눌 수 없다.")
  @Test
  public void 나누기_0_은_지원하지_않음 () {
    // given
    final String 입력 = "1 % 0";

    // when && then
    Assertions.assertThatThrownBy(() -> 계산기.calculate(입력))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @DisplayName("Calculator | 잘못된 형식의 단항식들은 허용하지 않는다.")
  @ParameterizedTest(name = "잘못된 단항식: {0}")
  @ValueSource(strings = {
      "1 % + 1",
      "1 1 +",
      "+ 1 2"
  })
  public void 잘못된_계산식 (String given) {
    // when && then
    Assertions.assertThatThrownBy(() -> 계산기.calculate(given))
        .isInstanceOf(IllegalArgumentException.class);
  }
}