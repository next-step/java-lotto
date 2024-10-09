package calculator.domain;

import calculator.exception.UnsupportedOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OperatorMasterTest {


    @DisplayName("덧셈을 할 수 있다.")
    @Test
    void additionTest() {
        // Given
        String operator = "+";
        int operand1 = 5;
        int operand2 = 3;

        // When
        int result = OperatorMaster.calculate(operator, operand1, operand2);

        // Then
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("뺄셈을 할 수 있다.")
    @Test
    void subtractionTest() {
        // Given
        String operator = "-";
        int operand1 = 5;
        int operand2 = 3;

        // When
        int result = OperatorMaster.calculate(operator, operand1, operand2);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("곱셈을 할 수 있다.")
    @Test
    void multiplicationTest() {
        // Given
        String operator = "*";
        int operand1 = 5;
        int operand2 = 3;

        // When
        int result = OperatorMaster.calculate(operator, operand1, operand2);

        // Then
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("나눗셈을 할 수 있다.")
    @Test
    void divisionTest() {
        // Given
        String operator = "/";
        int operand1 = 6;
        int operand2 = 3;

        // When
        int result = OperatorMaster.calculate(operator, operand1, operand2);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("0으로 나눌 경우 예외가 발생한다.")
    @Test
    void divisionByZeroTest() {
        // Given
        String operator = "/";
        int operand1 = 6;
        int operand2 = 0;

        // When & Then
        assertThatThrownBy(() -> OperatorMaster.calculate(operator, operand1, operand2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }

    @DisplayName("지원하지 않은 연산자가 입력되면 예외가 발생한다.")
    @Test
    void unsupportedOperatorTest() {
        // Given
        String operator = "%";
        int operand1 = 6;
        int operand2 = 3;

        // When & Then
        assertThatThrownBy(() -> OperatorMaster.calculate(operator, operand1, operand2))
                .isInstanceOf(UnsupportedOperatorException.class)
                .hasMessageContaining("지원하지 않는 연산자입니다.");
    }
}
