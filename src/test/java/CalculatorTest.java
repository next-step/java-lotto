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

    @Test
    @DisplayName("두 수를 더한 값을 반환한다.")
    void add() {
        int actual = Calculator.add(1, 2);

        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("앞 수에서 뒷 수를 뺀 값을 반환한다.")
    void subtract() {
        int actual = Calculator.subtract(2, 1);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("두 수를 곱한 값을 반환한다.")
    void multiply() {
        int actual = Calculator.multiply(2, 3);

        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("앞 수에서 뒷 수를 나눈 값을 반환한다.")
    void divide() {
        int actual = Calculator.divide(6, 3);

        assertThat(actual).isEqualTo(2);
    }
}
