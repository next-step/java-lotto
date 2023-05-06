package study.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  @DisplayName("2 + 3 * 4 / 2 = 10 을 출력한다. 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정")
  public void test_1() {
    // given
    Calculator calculator = new Calculator();
    // when
    String result = calculator.run(() -> "2 + 3 * 4 / 2");
    // then
    assertThat(result).isEqualTo("10");
  }

  @Test
  @DisplayName("2 + 2 = 4")
  public void test_2() {
    // given
    Calculator calculator = new Calculator();
    // when
    String result = calculator.run(() -> "2 + 2");
    // then
    assertThat(result).isEqualTo("4");
  }

  @Test
  @DisplayName("2 * 2 = 4")
  public void test_3() {
    // given
    Calculator calculator = new Calculator();
    // when
    String result = calculator.run(() -> "2 * 2");
    // then
    assertThat(result).isEqualTo("4");
  }

  @Test
  @DisplayName("2 / 2 = 1")
  public void test_4() {
    // given
    Calculator calculator = new Calculator();
    // when
    String result = calculator.run(() -> "2 / 2");
    // then
    assertThat(result).isEqualTo("1");
  }

  @Test
  @DisplayName("2 - 2 = 0")
  public void test_5() {
    // given
    Calculator calculator = new Calculator();
    // when
    String result = calculator.run(() -> "2 - 2");
    // then
    assertThat(result).isEqualTo("0");
  }

  @Test
  @DisplayName("잘못된 입력 : 입력 값이 null이거나 빈 공백 문자일 경우")
  public void test_6() {
    // given
    Calculator calculator = new Calculator();
    // when
    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.run(() -> null);
    });

    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.run(() -> " ");
    });

    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.run(() -> "1 2");
    });
  }

  @Test
  @DisplayName("잘못된 입력 : 사칙연산 기호가 아닌 경우")
  public void test_7() {
    // given
    Calculator calculator = new Calculator();
    // when
    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.run(() -> "2 & 1");
    });

    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.run(() -> "& 2 1");
    });
  }

  @Test
  @DisplayName("사칙연산을 모두 포함하는 기능을 구현")
  public void test_8() {
    // given
    Calculator calculator = new Calculator();
    // when
    String result = calculator.run(() -> "2 + 3 * 4 / 2 - 10");
    // then
    assertThat(result).isEqualTo("0");
  }
}
