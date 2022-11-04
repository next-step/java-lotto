package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("문자열 계산기는 사칙연산 법칙이 아닌 입력 값에 따라 계산해 결과를 반환한다.")
    public void run_ShouldHaveNoMathematicalPriority() {
        int actual = Calculator.run("2 + 3 * 4 / 2");

        assertThat(actual).isEqualTo(10);
    }

    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자인 경우 IllegalArgumentException을 throw한다.")
    public void run_ShouldThrowIllegalArgumentExceptionWhenEmptyInput() {
        assertThatThrownBy(() -> Calculator.run(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 null 이거나 빈 공백 문자입니다.");
    }

    @Test
    @DisplayName("입력 값이 null 이거나 빈 공백 문자인 경우 IllegalArgumentException을 throw한다.")
    public void run_ShouldThrowIllegalArgumentExceptionWhenWrongOperator() {
        assertThatThrownBy(() -> Calculator.run("1 ? 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 사칙연산 기호입니다.");
    }
}
