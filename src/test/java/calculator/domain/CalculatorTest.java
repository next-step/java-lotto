package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

  @Test
  @DisplayName("홀수 인덱스에는 operand, 짝수 인덱스에 operator가 주어진 경우 계산하여 반환")
  public void calculate_정상_계산() {
    Calculator calculator = Calculator.createCalculator(List.of("1", "+", "6", "-", "2"));

    assertThat(calculator.calculate()).isEqualTo(5);
  }

  @Test
  @DisplayName("홀수 인덱스에 숫자가 아닌 입력값이 들어간 경우 IllegalArgumentException throw")
  public void create_Calculator_숫자_아닌_값() {
    assertThatThrownBy(() -> Calculator.createCalculator(List.of("1", "-", "d")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("양수를 입력해주세요.");
  }

  @Test
  @DisplayName("짝수 인덱스에 사칙연산 기호가 아닌 값이 들어간 경우 IllegalArgumentException throw")
  public void create_Calculator_사칙연산_아닌_값() {
    assertThatThrownBy(() -> Calculator.createCalculator(List.of("1", "^", "3")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바른 사칙 연산을 입력해주세요.");
  }

  @Test
  @DisplayName("계산이 불가능한 수식이 입력된 경우 IllegalArgumentException throw")
  public void create_Calculator_계산_불가() {
    assertThatThrownBy(() -> Calculator.createCalculator(List.of("1", "+")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("계산이 가능한 수식을 입력해주세요.");
  }

  @Test
  @DisplayName("0으로 나누려고 하는 경우 IllegalArgumentException throw")
  public void calculate_0_나누기() {
    Calculator calculator = Calculator.createCalculator(List.of("1", "/", "0", "-", "2"));
    assertThatThrownBy(() -> calculator.calculate())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0으로 나눌 수 없습니다. 다른 숫자를 입력해주세요.");
  }
}
