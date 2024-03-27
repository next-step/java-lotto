package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

  Calculator calculator;

  @BeforeEach
  public void setUp() {
    calculator = new Calculator();
  }

  @Test
  @DisplayName("입력이 null이면 에러를 반환한다")
  public void checkInputIsNull() {
    assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(null));
  }

  @ParameterizedTest
  @DisplayName("입력이 빈 공백이면 에러를 반환한다")
  @ValueSource(strings = {"", " ", "  "})
  public void checkInputIsEmpty() {
    assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(" "));
  }

  @Test
  @DisplayName("숫자가 아닌 값 중 사칙연산이 아니면 에러를 반환한다")
  public void checkInputIsAbnormal() {
    assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate("1 & 2"));
  }

  @Test
  @DisplayName("덧셈을 수행하는지 확인한다")
  public void add() {
    int result = calculator.calculate("1 + 2");
    assertEquals(3, result);
  }

  @Test
  @DisplayName("뺄셈을 수행하는지 확인한다")
  public void minus() {
    int result = calculator.calculate("1 - 2");
    assertEquals(-1, result);
  }

  @Test
  @DisplayName("곱셈을 수행하는지 확인한다")
  public void multiply() {
    int result = calculator.calculate("3 * 2");
    assertEquals(6, result);
  }

  @Test
  @DisplayName("나눗셈을 수행하는지 확인한다")
  public void divide() {
    int result = calculator.calculate("6 / 2");
    assertEquals(3, result);
  }

  @Test
  @DisplayName("덧셈과 뺄셈 복합 연산을 수행하는지 확인한다")
  public void addAndMinus() {
    int result = calculator.calculate("3 + 2 - 8 + 10");
    assertEquals(7, result);
  }


  @Test
  @DisplayName("곱셈과 나눗셈 복합 연산을 수행하는지 확인한다")
  public void multiplyAndDivide() {
    int result = calculator.calculate("3 * 10 / 5 * 7");
    assertEquals(42, result);
  }



  @Test
  @DisplayName("복합 연산을 우선 순위 없이 입력 순서에 따라 수행하는지 확인한다")
  public void complex() {
    int result = calculator.calculate("1 + 2 * 8 / 3");
    assertEquals(8, result);
  }

}
